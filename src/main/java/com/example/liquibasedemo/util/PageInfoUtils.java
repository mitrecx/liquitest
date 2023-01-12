package com.example.liquibasedemo.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PageInfoUtils {
    public static <PO, VO> PageInfo<VO> Po2Vo(PageInfo<PO> pageInfoPo, Function<PO, VO> convert) {
        // 创建Page对象，实际上是一个ArrayList类型的集合
        Page<VO> page = new Page<>(pageInfoPo.getPageNum(), pageInfoPo.getPageSize());
        page.setTotal(pageInfoPo.getTotal());

        PageInfo<VO> voPageInfo = new PageInfo<>(page);
        if (pageInfoPo.getTotal() > 0) {
            List<VO> voList = pageInfoPo.getList().stream().map(convert).collect(Collectors.toList());
            voPageInfo.getList().addAll(voList);
        }

        return voPageInfo;
    }

}
