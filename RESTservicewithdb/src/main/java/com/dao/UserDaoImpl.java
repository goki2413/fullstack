package com.dao;

import java.util.Iterator;
import java.util.List;







import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.User;
@Component
public class UserDaoImpl  implements IUserDao {
	@Autowired //userdao has a relation ship with sessionfactory
	private SessionFactory sessionFactory;
	
	
	@Override
	public User createUser(User user) {
		Session session=this.sessionFactory.openSession();
		//Transaction tx=session.beginTransaction();
		session.save(user);
		//tx.commit();
		return user;
	}

	
	@Override
	public List<User> readUser() {
		Session session=this.sessionFactory.openSession();
		String readUser="from User";
		List<User> users=session.createQuery(readUser).list();
		return users;
	}

	
	
	@Override
	public User readUserById(int userId) {
		Session session=this.sessionFactory.openSession();
		User user=null;
		 String readUserById="from User where userId=:userid";
		 Query query=session.createQuery(readUserById);
		 query.setParameter("userid",userId);
	     List<User> users=query.getResultList();
		 /*Iterator itr=users.iterator();
		  while(itr.hasNext()){
			 user=(User) itr.next();
		  }*/
		return users.get(0);
	}

	
	
	
	@Override
	public User getUserByName(String userName) {
		Session session=this.sessionFactory.openSession();
		User user=null;
		 String readUserById="from User where userName=:username";
		 Query query=session.createQuery(readUserById);
		 query.setParameter("username",userName);
	     List<User> users=query.getResultList();
		 Iterator itr=users.iterator();
		  while(itr.hasNext()){
			 user=(User) itr.next();
		  }
		return user;
		
	}

	
	
	@Override
	public User updateUser(User user) {
		Session session=this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		//User user1=null;
		/*String updateuser="update User set userName=:userName,password=:password where userId=:userId";
		 Query query2=session.createQuery(updateuser);
		 query2.setParameter("userId",user.getUserId());
		 query2.setParameter("userName", user.getUserName());
		 query2.setParameter("password", user.getPassword());
			int i= query2.executeUpdate();
			if(i>0){
				System.out.println("updated");
			}
			else
				System.out.println("not updated");*/
	
		//tx.commit();
		//Transaction tx1=session.beginTransaction();
		User obj= session.load(User.class,user.getUserId());
		session.saveOrUpdate(user);
		//user1=this.readUserById(user.getUserId());
		tx.commit();
		
		return obj;
	
	}

	
	
	@Override
	public User deleteById(int userId) {
		Session session=this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		//User user=null;
		/*String readUserById="from User where userId=:userid";
		 Query query1=session.createQuery(readUserById);
		 query1.setParameter("userid",userId);
	     List<User> users=query1.getResultList();
		 Iterator itr=users.iterator();
		  while(itr.hasNext()){
			 user=(User) itr.next();
		  }*/
		 // User obj = (User) session.load(User.class, new Integer(userId));
		User obj= session.load(User.class,userId);
		  session.delete(obj);
		/*String deleteuser="delete from User  where userId=:userId";
		Query query2=session.createQuery(deleteuser);
		 query2.setParameter("userId",userId);
		int i= query2.executeUpdate();
		if(i>0){
			System.out.println("deleted");
		}
		else
			System.out.println("not deleted");*/
		  tx.commit();
		return obj;
		

}
}