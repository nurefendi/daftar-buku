package com.mazayaku.entity.common;

import com.mazayaku.entity.fields.BaseEntityFields;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
  @CreatedDate
  @Column(name = BaseEntityFields.CREATED_DATE)
  private Date createdDate;

  @CreatedBy
  @Column(name = BaseEntityFields.CREATED_BY)
  private String createdBy;

  @LastModifiedDate
  @Column(name = BaseEntityFields.UPDATED_DATE)
  private Date updatedDate;

  @LastModifiedBy
  @Column(name = BaseEntityFields.UPDATED_BY)
  private String updatedBy;
}
