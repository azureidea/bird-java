package com.bird.service.zero;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.bird.core.utils.SpringContextHolder;
import com.bird.service.zero.mapper.OrganizationMapper;
import com.bird.service.zero.model.Organization;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication(scanBasePackages = "com.bird")
@MapperScan("com.bird.service.zero.mapper")
@DubboComponentScan(basePackages = "com.bird.service.zero")
public class Bootstrap {

	public static void main(String[] args) {
		SpringApplication.run(Bootstrap.class, args);

		OrganizationMapper mapper = SpringContextHolder.getBean(OrganizationMapper.class);
		EntityWrapper<Organization> wrapper = new EntityWrapper<>();
		List<Organization> organizations = mapper.selectList(wrapper);

		mapper.deleteById(1L);
	}
}
