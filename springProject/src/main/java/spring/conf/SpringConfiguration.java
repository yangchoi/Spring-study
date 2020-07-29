package spring.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import board.bean.BoardDTO;
import board.dao.BoardDAOMybatis;
import board.service.BoardServiceImpl;
import member.bean.MemberDTO;
import member.dao.MemberDAOMybatis;
import member.service.MemberServiceImpl;

@Configuration
public class SpringConfiguration {
	@Autowired
	private ApplicationContext applicationContext;

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

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("spring/mybatis-config.xml"));
		// sqlSessionFactoryBean.setMapperLocations(new
		// ClassPathResource("member/dao/memberMapper.xml"));
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:*/dao/*Mapper.xml"));

		return sqlSessionFactoryBean.getObject();
	}
	
	/*
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		PathMatchingResourcePatternResolver resource = new PathMatchingResourcePatternResolver();	
		sqlSessionFactoryBean.setDataSource(dataSource());
		
		// 여기 datasource는 값이 아니고 메서드이다 .
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("spring/mybatis-config.xml")); // config 위치
		sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("member/dao/memberMapper.xml")); // mapper 위치
		sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("board/dao/boardMapper.xml")); 
		
		
		return sqlSessionFactoryBean.getObject(); 
		
			
	}
	*/	

	@Bean
	public SqlSessionTemplate sqlSession() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		return transactionManager;

	}
	
	@Bean
	public MemberServiceImpl memberServiceImpl() {
		return new MemberServiceImpl();
	}
	
	@Bean
	public MemberDTO memberDTO() {
		return new MemberDTO();
	}
	
	@Bean
	public MemberDAOMybatis memberDAOMybatis() {
		return new MemberDAOMybatis();
	}
	
	@Bean
	public BoardDAOMybatis boardDAOMybatis() {
		return new BoardDAOMybatis();
	}
	
	@Bean
	public BoardDTO boardDTO() {
		return new BoardDTO();
	}
	
	@Bean
	public BoardServiceImpl boardServiceImpl() {
		return new BoardServiceImpl();
	}
	

}
