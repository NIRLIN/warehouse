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
public class Supplier {

  private String id;
  private String name;
  private String address;
  private String phone;


}
