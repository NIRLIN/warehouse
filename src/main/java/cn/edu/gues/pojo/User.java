package cn.edu.gues.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author NIRLIN
 * @version 1.0
 * @date 2020/7/13 15:37
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private String id;
  private String jobNo;
  private String password;
  private String role;
  private String name;
  private String phone;
  private String work;
  private String sex;
  private java.sql.Date birthday;
  private String nation;


}
