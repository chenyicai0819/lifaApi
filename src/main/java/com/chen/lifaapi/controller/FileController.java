package com.chen.lifaapi.controller;

import com.chen.lifaapi.core.ResponseData;
import com.chen.lifaapi.entity.Vips;
import com.chen.lifaapi.service.VipBatchService;
import com.chen.lifaapi.service.VipsService;
import com.chen.lifaapi.utils.DownloadFile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.controller
 * @date 2022/4/15 22:37
 * @since 1.0
 */

@RestController
@Api(description ="文件上传下载控制器")
@RequestMapping("/file")
public class FileController {

    @Autowired
    private VipBatchService vbs;
    @Autowired
    private VipsService vs;

    @ApiOperation(value = "下载批量导入会员的模板")
    @RequestMapping("/downloadTemplate")
    public String downloadHcTemplate(HttpServletResponse response) {
        String fileName = "vipAddTemplate.xlsx";     // 默认下载的文件名，根据业务需要替换成要下载的文件名
        InputStream fileInputStream = this.getClass().getResourceAsStream("/static/vipAddTemplate.xlsx");
        if (fileInputStream != null) {
            DownloadFile.DownloadExcelByIO(response, fileInputStream, fileName);
        }else {
            return "<h1 style='color: red; text-align: center'>文件不存在，请联系开发人员添加文件模板</h1>";
        }
        return "<h1 style='color: red; text-align: center'>下载成功，可关闭当前页面，请前往下载路径查看</h1>";
    }

    @ApiOperation(value = "批量导入会员")
    @RequestMapping(value = "/insertVipBatch", method = RequestMethod.POST)
    public ResponseData insertHcBatch(@RequestParam(value = "vipFile", required = false) MultipartFile vipFile) {
        // 获得文件名
        String name = vipFile.getOriginalFilename();
        // 后缀名
        String suffixName;
        if(name != null){
            suffixName = name.substring(name.indexOf("."));
        }else {
            return new ResponseData("文件名不能为空！");
        }
        if(!suffixName.equals(".xlsx")){
            return new ResponseData("文件格式错误");
        }
        try {
            List<Vips> vipDataList = this.excelToList(vipFile.getInputStream());
            if(vipDataList == null) {
                return new ResponseData("文件内容为空");
            }
            int i = vs.insertVipBatch(vipDataList);
            if(i == 0) {
                return new ResponseData("上传失败！请重新上传，并关注耗材列表是否添加成功");
            }
            return new ResponseData("true","上传成功！请勿重复上传文件！", i);
        } catch (IOException e) {
            System.err.println("解析耗材文件错误:"+ e);
        }
        return new ResponseData("上传失败！");
    }

    /**
     * 解析上传的文件内容
     * @param inputStream 文件 IO
     * @return 解析后，耗材数据的集合
     */
    public List<Vips> excelToList(InputStream inputStream) {
        return vbs.excelToList(inputStream);
    }
}
