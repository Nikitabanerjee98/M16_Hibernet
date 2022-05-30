package com.cg.dao;

import javax.persistence.EntityManager;

import com.cg.entities.Student;

public class StudentDaoImp implements StudentDao
{
	private EntityManager entityManager;
	

	public StudentDaoImp(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	public StudentDaoImp() 
	{
		entityManager=JPAUtil.getEntityManager();
		
	}

	@Override
	public void addStudent(Student student) {
		entityManager.persist(student);
		
	}

	@Override
	public Student getStudentById(int ID) {
		Student student =entityManager.find(Student.class,ID);
		return student;
		
	}

	@Override
	public void updateStudent(Student student) {
		entityManager.merge(student);
		
	}

	@Override
	public void removeStudent(Student student) {
		entityManager.remove(student);
		
	}

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
		
	}

	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}
	

}
