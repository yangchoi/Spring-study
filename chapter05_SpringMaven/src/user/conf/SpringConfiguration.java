package user.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import user.bean.UserDTO;
import user.dao.UserDAOMybatis;
import user.main.HelloSpring;
import user.service.UserDeleteService;
import user.service.UserInsertService;
import user.service.UserSelectService;
import user.service.UserUpdateService;

@Configuration
public class SpringConfiguration {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		basicDataSource.setUsername("java");
		basicDataSource.setPassword("bit");
		basicDataSource.setMaxTotal(20);
		basicDataSource.setMaxIdle(3);
		
		
		return basicDataSource;
	}
	/*
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		PathMatchingResourcePatternResolver resource = new PathMatchingResourcePatternResolver();	
		sqlSessionFactoryBean.setDataSource(dataSource());
		
		// 여기 datasource는 값이 아니고 메서드이다 .
		sqlSessionFactoryBean.setConfigLocation(resource.getResource("spring/mybatis-config.xml")); // config 위치
		sqlSessionFactoryBean.setMapperLocations(resource.getResources("user/dao/userMapper.xml")); // mapper 위치
		
		return sqlSessionFactoryBean.getObject(); // 리턴값과 반환형의 타입이 다르기 때문에 리턴값을 getObject 해주어 객체화해준다. 
		// bean을 통한 sqlSessionFactory를 원하기 때문에 리턴값을 객체화해줌..
		// sqlSessionFactory를 필드 선언해서 
		
	}
	*/
	// 아래는 getObject 없이 sqlSessionFfactoryBean 직접 리턴하는 버전
	// 대신 경로를 new ClassPathResource를 이용해서 지정해준다. 
	// 그러면 exception 걸 지 않아도 된다. 
	// SqlSessionFactory를 직접 필드선언해주고 Autowired 어노테이션을 걸어준다. 
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		PathMatchingResourcePatternResolver resource = new PathMatchingResourcePatternResolver();	
		sqlSessionFactoryBean.setDataSource(dataSource());
		
		// 여기 datasource는 값이 아니고 메서드이다 .
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("spring/mybatis-config.xml")); // config 위치
		sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("user/dao/userMapper.xml")); // mapper 위치
		
		return sqlSessionFactoryBean; 
		
		
	}
	
	@Bean
	public SqlSessionTemplate sqlSession() throws Exception{
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		return transactionManager;
		
	}
	
	
	@Bean
	public HelloSpring helloSpring(){
		return new HelloSpring();
	}
	
	@Bean
	public UserInsertService userInsertService() {
		return new UserInsertService();
	}
	
	@Bean
	public UserSelectService userSelectService() {
		return new UserSelectService();
	}
	
	@Bean
	public UserUpdateService userUpdateService() {
		return new UserUpdateService();
	}
	
	@Bean
	public UserDeleteService userDeleteService() {
		return new UserDeleteService();
	}
	
	@Bean
	public UserDTO userDTO() {
		return new UserDTO();
	}
	
	@Bean
	public UserDAOMybatis userDAOMybatis() {
		return new UserDAOMybatis();
	}
	
}













