package com.spearhead.nova.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class About extends DateAudit {
    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(generator = "audit_user_generator")
    @SequenceGenerator(
   		name = "audit_user_generator",
   		sequenceName = "audit_user_sequence",
   		initialValue = 100
   		)

           private Long aboutId;
           @Column(name="aboutText", length=512, nullable = false)
           private String aboutText;
		public Long getAboutId() {
			return aboutId;
		}
		public void setAboutId(Long aboutId) {
			this.aboutId = aboutId;
		}
		public String getAboutText() {
			return aboutText;
		}
		public void setAboutText(String aboutText) {
			this.aboutText = aboutText;
		}
		public About(Long aboutId, String aboutText) {
			this.aboutId = aboutId;
			this.aboutText = aboutText;
		}
		@Override
		public String toString() {
			return "About [aboutId=" + aboutId + ", aboutText=" + aboutText + "]";
		}
		public About() {
            super();
		}

    
}
