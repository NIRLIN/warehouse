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
public class Record {

  private String id;
  private String cargoId;
  private String entrepotId;
  private String operation;
  private String number;
  private double price;
  private double sumPrice;
  private java.util.Date createTime;

}
