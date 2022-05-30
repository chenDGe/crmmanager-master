package com.crm.service;

import com.crm.dao.AskerMapper;
import com.crm.entity.Askers;
import com.crm.util.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AskerService {
    /**
     * 查询所有咨询师
     * @return  咨询师集合
     */
    List<Askers> queryAskersAll();

    /**
     * 根据咨询师id查询咨询师
     * @param askerId   咨询师id
     * @return  传值实体类
     */
    Result queryAskerByAskerId(String askerId);

    /**
     * 查询当天可以分配学生的咨询师权重倒叙的第一个
     * @return 咨询师集合
     */
    Askers queryAskerByCheckOrderWeight();

    /**
     * 修改咨询师是否分配学生
     * @param askerId   咨询师id
     * @param changeState   分配学生状态
     * @return 受影响的行数
     */
    int updateAskerChangeState(@Param("askerId") String askerId,@Param("changeState") String changeState);

    /**
     * 分页查询咨询师
     * @param askerName 咨询师姓名
     * @param offsex    偏移量
     * @param rows  条数
     * @return 所有咨询师集合
     */
    List<Askers> queryAskersPaging(String askerName,int offsex,int rows);

    /**
     * 查询不带limit的总条数
     * @return  总条数
     */
    int queryAskersPagingColumn();

    /**
     * 分页查询咨询师
     * @param askerName
     * @param page  第几页
     * @param rows  条数
     * @return  total 总数 rows咨询师对象集合
     */
    Map queryAskerPagingMain(String askerName,int page,int rows);

    /**
     * 修改咨询师的权重和备注
     * @param askerId   咨询师id
     * @param weight   权重
     * @param bakContent    备注
     * @return  传值实体类
     */
    Result updateAskerWeightAndContext(String askerId,int weight,String bakContent);

    /**
     * 修改某一列的值
     * @param askerId 咨询师id
     * @param fieldName 字段名称
     * @param fieldValue    字段value
     * @return  受影响的行数
     */
    int updateAskerField(String askerId,String fieldName,Object fieldValue);

    /**
     * 新增咨询师
     * @param askers 咨询师id
     * @return  受影响的行数
     */
    int addAsker(Askers askers);

    /**
     * 删除咨询师
     * @param askerId   咨询师id
     * @return  受影响的行数
     */
    int deleteAskerByid(@Param("askerId") String askerId);

    /**
     * 查询所有已经签到的咨询师
     * @return  咨询师
     */
    List<Askers> queryAskersByCheck();

    /**
     * 修改全部已经签到的咨询师的是否分配学生为 是
     * @return
     */
    int updateAskerIsChange();

}
