
package com.spring.tx.springtransaction.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Payment_Info")
public class PaymentInfo {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2",strategy = "org.hibernate.id.UUIDGenerator")
	private String paymentId;
	private String accountNo;
	private double amount;
	private String cardType;
	private Long passengerId;
}
