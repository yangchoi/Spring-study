package spring.conf;

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

import member.dao.MemberDAOMybatis;

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

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		PathMatchingResourcePatternResolver resource = new PathMatchingResourcePatternResolver();	
		sqlSessionFactoryBean.setDataSource(dataSource());
		
		// 여기 datasource는 값이 아니고 메서드이다 .
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("spring/mybatis-config.xml")); // config 위치
		sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("member/dao/memberMapper.xml")); // mapper 위치
		
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
	public MemberDAOMybatis memberDAOMybatis() {
		return new MemberDAOMybatis();
	}
	
}

