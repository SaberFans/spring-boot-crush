package ty.springboot.mybatis;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{


	private CityMapper citymapper;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public DemoApplication(CityMapper cityMapper) {
		this.citymapper = cityMapper;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(citymapper.findState("CA"));
	}
}
