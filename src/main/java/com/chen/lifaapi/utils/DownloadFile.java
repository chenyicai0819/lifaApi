package com.chen.lifaapi.utils;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.chen.lifaapi.entity.Vips;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Young Kbt
 * @date 2021/12/20 22:04
 * @description 下载文件
 */
@Component
public class DownloadFile {




    /**
     * 传入文件地址的流，下载 Excel 文件
     * 适用于获取 resource 的文件，因为生产环境无法直接通过文件路径获取，文件路径只适用于开发
     * @param response 响应
     * @param fileInputStream 文件流
     * @param fileName 文件名
     */
    public static void DownloadExcelByIO(HttpServletResponse response, InputStream fileInputStream, String fileName) {
        response.setContentType("application/octet-stream");
        response.setHeader("content-type", "application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;fileName=" + new String(fileName.getBytes()));   // 设置文件名
        byte[] buffer = new byte[1024];
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(fileInputStream);
            OutputStream os = response.getOutputStream();
            int len;
            while (-1 != (len = bis.read(buffer, 0, buffer.length))) {
                os.write(buffer, 0, len);
            }
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 传入文件地址的流，下载 Excel 文件
     * 适用于获取 resource 的文件，因为生产环境无法直接通过文件路径获取，文件路径只适用于开发
     *
     */
    public void DownloadExcelByIO(HttpServletResponse response) {
        List<Vips> vips=new ArrayList<>();

        ExcelWriter writer= ExcelUtil.getWriter();
        writer.addHeaderAlias("vipId", "会员ID");
        writer.addHeaderAlias("vipType", "会员类型");
        writer.addHeaderAlias("vipName", "会员姓名");
        writer.addHeaderAlias("vipPassword", "会员密码");
        writer.addHeaderAlias("vipPhone", "会员电话");
        writer.addHeaderAlias("vipSex", "会员性别");
        writer.addHeaderAlias("vipBirthday", "会员生日");
        writer.addHeaderAlias("vipOpencard", "开卡时间");
        writer.addHeaderAlias("vipsMoney", "会员卡金");
        writer.addHeaderAlias("vipsConsume", "会员消费");
        writer.addHeaderAlias("vipsBonus", "会员奖金");
        writer.addHeaderAlias("vipsLast", "最后消费时间");
        writer.merge(1, "会员信息表");
        writer.write(vips, true);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");

        String name = "理发店会员信息表";

        response.setHeader("Content-Disposition", "attachment;filename=" + name + ".xls");
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            writer.flush(out, true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
        IoUtil.close(out);

    }

    /**
     * 导出账单记录
     * @param response
     */
    public void DownloadOrderExcelByIO(HttpServletResponse response) {
        List<Vips> vips=new ArrayList<>();

        ExcelWriter writer= ExcelUtil.getWriter();
        writer.addHeaderAlias("orderId", "编号");
        writer.addHeaderAlias("orderPrice", "价格");
        writer.addHeaderAlias("orderDate", "日期");
        writer.addHeaderAlias("orderText", "账单内容");
        writer.addHeaderAlias("orderMan", "客户姓名");
        writer.addHeaderAlias("orderPhone", "客户联系方式");
        writer.addHeaderAlias("orderSex", "客户性别");
        writer.addHeaderAlias("payType", "支付方式");
        writer.addHeaderAlias("orderMoney", "实付金额");
        writer.addHeaderAlias("orderWorker", "发型师");
        writer.addHeaderAlias("orderOrderWorker", "中工");
        writer.addHeaderAlias("orderCome", "客户来源");
        writer.addHeaderAlias("orderRemake", "账单备注");
        writer.merge(1, "营业记录表");
        writer.write(vips, true);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");

        String name = "理发店营业记录表";

        response.setHeader("Content-Disposition", "attachment;filename=" + name + ".xls");
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            writer.flush(out, true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
        IoUtil.close(out);

    }

}
