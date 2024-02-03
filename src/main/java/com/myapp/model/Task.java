package com.myapp.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

	private int taskId;
	private String name;
	private String note;

	private TaskStatus taskStatus;

	private TaskType taskType;

	private boolean active;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

}
