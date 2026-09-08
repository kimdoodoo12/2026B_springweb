package example.mini2_erd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * productlog : 상품 재고/입출고 로그.  productlog(N) : product(1)
 * mini2.sql 기준으로 FK 컬럼은 product_no.
 * (컬럼명은 MySQL 에서 대소문자 무시라 productLog_no == productlog_no 로 매칭됨)
 */
@Entity
@Table(name = "productlog")
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class ProductLogEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productlog_no")
    private Integer productLogNo;

    // ===== productlog(N) : product(1) =====  주인(FK 보유)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_no")   // productlog.product_no -> product.product_no
    @ToString.Exclude
    private ProductEntity product;

    @Column(name = "product_qty")
    private Integer productQty;

    @Column(name = "product_condition", length = 20)
    private String productCondition;

    @Column(name = "productlog_price")
    private Integer productLogPrice;

    @Column(name = "customerlog_day")
    private Integer customerLogDay;
}
