package com.example.sell.utils;

import com.example.sell.service.VO.ResultVO;

/**
 * @Author: maoyuyang
 * @Description: 数据返回的最外层格式对象
 * @Date: 11:34 18/11/1
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);

        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        resultVO.setData(null);

        return resultVO;
    }
}
