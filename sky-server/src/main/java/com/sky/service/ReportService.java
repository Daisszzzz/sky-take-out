package com.sky.service;

import com.sky.vo.TurnoverReportVO;

import java.time.LocalDate;

/**
 * @ClassName ReportService
 * @Author lenovo
 * @Date 2025/4/27 7:52
 **/
public interface ReportService {


    TurnoverReportVO getTurnoverStatistics(LocalDate begin, LocalDate end);
}
