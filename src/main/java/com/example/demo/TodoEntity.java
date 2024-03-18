package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
@Table(name = "todo")
public class TodoEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "title")
  private String title;

  @Column(name = "done")
  private Boolean done;

  @CreationTimestamp
  @Column(name = "created_at", nullable = false)
  private Timestamp createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", nullable = false)
  private Timestamp updatedAt;

}