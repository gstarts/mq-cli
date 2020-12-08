package com.lhzn.soft.project.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 消息历史记录 MessageHistory
 *
 * @author qishuai
 * @date 2020-11-24
 */
public class MessageHistory implements Serializable{
    /** 主键 */
    private Long id ;
    /** 队列名称;该消息是从哪个队列中获取 */
    private String queueName ;
    /** 消息内容 */
    private String body ;
    /** 消息状态;向服务器发送时状态0:失败1:成功 */
    private String status ;
    /** 场所标识 */
    private String locationId ;
    /** 乐观锁 */
    private Integer revision ;
    /** 创建人 */
    private String createdBy ;
    /** 创建时间 */
    private Date createdTime ;
    /** 更新人 */
    private String updatedBy ;
    /** 更新时间 */
    private Date updatedTime ;

    /** 主键 */
    public Long getId(){
        return this.id;
    }
    /** 主键 */
    public void setId(Long id){
        this.id = id;
    }
    /** 队列名称;该消息是从哪个队列中获取 */
    public String getQueueName(){
        return this.queueName;
    }
    /** 队列名称;该消息是从哪个队列中获取 */
    public void setQueueName(String queueName){
        this.queueName = queueName;
    }
    /** 消息内容 */
    public String getBody(){
        return this.body;
    }
    /** 消息内容 */
    public void setBody(String body){
        this.body = body;
    }
    /** 消息状态;向服务器发送时状态0:失败1:成功 */
    public String getStatus(){
        return this.status;
    }
    /** 消息状态;向服务器发送时状态0:失败1:成功 */
    public void setStatus(String status){
        this.status = status;
    }
    /** 场所标识 */
    public String getLocationId(){
        return this.locationId;
    }
    /** 场所标识 */
    public void setLocationId(String locationId){
        this.locationId = locationId;
    }
    /** 乐观锁 */
    public Integer getRevision(){
        return this.revision;
    }
    /** 乐观锁 */
    public void setRevision(Integer revision){
        this.revision = revision;
    }
    /** 创建人 */
    public String getCreatedBy(){
        return this.createdBy;
    }
    /** 创建人 */
    public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
    }
    /** 创建时间 */
    public Date getCreatedTime(){
        return this.createdTime;
    }
    /** 创建时间 */
    public void setCreatedTime(Date createdTime){
        this.createdTime = createdTime;
    }
    /** 更新人 */
    public String getUpdatedBy(){
        return this.updatedBy;
    }
    /** 更新人 */
    public void setUpdatedBy(String updatedBy){
        this.updatedBy = updatedBy;
    }
    /** 更新时间 */
    public Date getUpdatedTime(){
        return this.updatedTime;
    }
    /** 更新时间 */
    public void setUpdatedTime(Date updatedTime){
        this.updatedTime = updatedTime;
    }
}