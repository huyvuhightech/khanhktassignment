package vn.titv.spring.JPA.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.titv.spring.JPA.dao.SinhVienDAOImpl;
import vn.titv.spring.JPA.entity.SinhVien;

import java.util.Scanner;

@Configuration
public class MyConfiguration {
    @Bean
    public CommandLineRunner getRunner(SinhVienDAOImpl sinhVienDAOImpl){
        return runner->{
            Scanner scanner = new Scanner(System.in);
            while(true) {
                printMenus();
                int choose = scanner.nextInt();
                scanner.nextLine(); // Xử lý trôi lệnh (nuốt dòng new line sau khi nhập số)

                if(choose == 1) {
                    // Gọi phương thức thêm sinh viên
                    // Lấy thông tin sinh viên
                    System.out.println("Moi ban dien thong tin fullname");
                    String ho_dem = scanner.nextLine();

                    System.out.println("Nhập tên như cặc: ");
                    String ten = scanner.nextLine();

                    System.out.println("Nhập email: ");
                    String email = scanner.nextLine();

                    // Tạo đối tượng SinhVien mới
                    SinhVien sinhVien = new SinhVien(ho_dem, ten, email);

                    // Lưu xuống CSDL
                    sinhVienDAOImpl.save(sinhVien);
                }
            }
        };
    }

    public void printMenus(){
        System.out.println("========================================\n");
        System.out.println("MENU:\n" +
                "1. Thêm sinh viên\n" +
                "2. Tìm sinh viên\n" +
                "3. Xóa sinh viên\n"
        );
    }
}
