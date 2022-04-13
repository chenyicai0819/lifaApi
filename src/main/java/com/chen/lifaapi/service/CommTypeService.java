package com.chen.lifaapi.service;

import com.chen.lifaapi.entity.Commoditytype;
import org.yaml.snakeyaml.comments.CommentType;

import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service
 * @date 2022/2/15 22:12
 * @since 1.0
 */
public interface CommTypeService {
    List<Commoditytype> getAllType();
}
