package com.myapp.dao;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import com.myapp.model.Task;

import java.util.List;

@Repository
public class TaskDao {
	private JdbcClient jdbcClient;

	public TaskDao(JdbcClient jdbcClient) {
		this.jdbcClient = jdbcClient;
	}

	public List<Task> findAll() {
		String query = "select * from task";

		return jdbcClient.sql(query).query(Task.class).list();
	}

	public Task findById(int id) {
		String query = "select * from task where task_id =?";

		return jdbcClient.sql(query).param(1, id).query(Task.class).single();

	}

	public Task saveTask(Task task) {
		String query = "insert into task(task_id, name, active) values(?,?,?)";

		jdbcClient.sql(query).param(1, task.getTaskId()).param(2, task.getName()).param(3, task.isActive()).update();
		System.out.println("task added");
		return task;

	}

	public void update(Task task) {
		String query = "update task set name =?, active =? where task_id= ?";

		jdbcClient.sql(query).param(1, task.getName()).param(2, task.isActive()).param(3, task.getTaskId()).update();

	}

	public void deleteById(Integer id) {
		String query = "delete from task where task_id =?";
		jdbcClient.sql(query).param(1, id).update();

	}

}