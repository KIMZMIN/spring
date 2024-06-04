package com.yedam.app.aop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement  //매니저를 등록하려면 이걸 등록해야함   // + 일단 지금 @Transactional을 쓰려고 이걸 만든건데 
															  // 이거 없어도 일단 돌아가서 주석처리했음.
//파일업로드나 관련 빈들을 사용할때 이 틀을 사용함.
public class DBConfig {
	/*
	 * @Bean TransactionManager transactionManager(DataSource dataSource) { return
	 * new DataSourceTransactionManager(dataSource); } //얘를 등록해야 @Transactional이 작동?
	 */
}
