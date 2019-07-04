package com.example.demo.seeders;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Category;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.AuthoritiesConstants;

/**
 * Created by TrinhNguyen on 3/12/2018.
 */
@Component
public class DatabaseSeeder {
	private Logger logger = LoggerFactory.getLogger(DatabaseSeeder.class);
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private CategoryRepository categoryRepository;

	@Autowired
	public DatabaseSeeder(UserRepository userRepository, RoleRepository roleRepository,
			CategoryRepository categoryRepository) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.categoryRepository = categoryRepository;
	}

	@EventListener
	public void seed(ContextRefreshedEvent event) {
		seedRolesTable(AuthoritiesConstants.ADMIN);
		seedRolesTable(AuthoritiesConstants.EMPLOYEE);
		seedUsersTable();
		seedCategorysTable();
	}

	private void seedCategorysTable() {

		Iterable<Category> categoryCheck = categoryRepository.findAll();

		if (categoryCheck == null) {
			Category category1 = new Category();
			category1.setName("Văn Học");
			categoryRepository.save(category1);

			Category category2 = new Category();
			category2.setName("Kiến Trúc");
			categoryRepository.save(category2);

			Category category3 = new Category();
			category3.setName("Tiểu thuyết");
			categoryRepository.save(category3);

			Category category4 = new Category();
			category4.setName("Khoa Học");
			categoryRepository.save(category4);

			Category category5 = new Category();
			category5.setName("Toán Học");
			categoryRepository.save(category5);

			Category category6 = new Category();
			category6.setName("Kinh Tế");
			categoryRepository.save(category6);

			Category category7 = new Category();
			category7.setName("Mỹ Thuật");
			categoryRepository.save(category7);

		}
	}

	private void seedRolesTable(String roleName) {

		Role r = roleRepository.findByName(roleName);

		if (r == null) {
			Role roleAdmin = new Role();
			roleAdmin.setName(AuthoritiesConstants.ADMIN);
			roleRepository.save(roleAdmin);

			Role roleEmployee = new Role();
			roleEmployee.setName(AuthoritiesConstants.EMPLOYEE);
			roleRepository.save(roleEmployee);
		}
	}

	private void seedUsersTable() {
		User userCheck = userRepository.findByUsername("admin@gmail.com");

		if (userCheck == null) {
			User user = new User();
			user.setFirstName("Nguyen");
			user.setLastName("Trinh");
			user.setStatus(1);
			user.setUsername("admin@gmail.com");
			user.setPhone("0");
			user.setPassword(new BCryptPasswordEncoder().encode("123456789o"));

			Role roleAdmin = roleRepository.findByName(AuthoritiesConstants.ADMIN);
			Role roleUser = roleRepository.findByName(AuthoritiesConstants.EMPLOYEE);

			Set<Role> roles = new HashSet<>();
			roles.add(roleAdmin);
			roles.add(roleUser);
			user.setRoles(roles);

			userRepository.save(user);
			logger.info("Users Seeded");
		} else {
			logger.trace("Users Seeding Not Required");
		}
	}
}
