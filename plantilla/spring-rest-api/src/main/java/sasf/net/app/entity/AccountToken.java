package sasf.net.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


public class AccountToken  implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

    @Column(name = "token", length = 85)
    private String token;

    @Column(name = "expiration")
    private Long expiration;

    @Column(name = "type_token", length = 50, nullable = false)
    private String typeToken;

    @Column(name = "validate", columnDefinition = "boolean default false")
    private boolean validate;
}
