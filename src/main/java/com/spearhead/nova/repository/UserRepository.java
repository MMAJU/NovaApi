package com.spearhead.nova.repository;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;


import java.util.List;
import com.spearhead.nova.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

	Optional<User> findByUserId(Long adminId);
	
	Optional<User> findAllByEmailOrCustomerId(String username, String username2);
	
	//Optional<User> findByCustomerId(String customerId);


	
	Optional <User> findByCustomerId(String customerId);
	Optional <User> findByOneTimePassword(String oneTimePassword);
	Optional <User> findByVerificationOtp(String verificationOtp);

	


	@Modifying
	@Transactional
	@Query(
		value = " update users Set one_time_password = ?1, otp_requested_time = ?2 where email = ?3",
		nativeQuery = true
	)
	int sendNotificationByEmail(String oneTimePassword,  Date otpRequestedTime,  String email);

	//int otpNotification(String oneTimePassword, Date otpRequestedTime, String email)
	//public ResponseEntity<User> findCustomerId(String customerId);
	//Start
	@Modifying
	@Transactional
	@Query(
		value = " update users Set email_one_time_password = ?1, email_requested_time = ?2 where email = ?3",
		nativeQuery = true
	)
	int sendEmailNotificationByEmail(String email_one_time_password,  Date email_requested_time,  String email);
	//End //


	@Modifying
	@Transactional
	@Query(
		value = " update users Set password = ?1 where email = ?2",
		nativeQuery = true
	)
	int updatePassword(String password ,  String email);
	//End //

	@Transactional
	@Query(
		value = " select  one_time_password from users where  one_time_password = :oneTimePassword",
		nativeQuery = true
	)

	Optional<User>fetchOneTimePassword(@Param("oneTimePassword") String oneTimePassword);

	@Transactional
	@Query(
		value = " select  otp_requested_time from users where  email = :mail",
		nativeQuery = true
	)
	Optional<User> fetchOtpRequestedTime(@Param("mail") String mail);



	// @Transactional
	// @Query(
	// 	value = " select  verification_otp from users where  verification_otp = :verificationOtp",
	// 	nativeQuery = true
	// )
	// Optional<User>fetchVerficationCode(@Param("verificationOtp") String verificationOtp);


     @Modifying
     @Query(value = "UPDATE users u set is_verified =:isVerifiedStatus where u.verification_otp = :verificationOtp",
             nativeQuery = true)
	 		int upddateVerficationCode(@Param("isVerifiedStatus") boolean isVerifiedStatus, @Param("verificationOtp") String userId);




	public User findByEmailOneTimePassword(String email_one_time_password);
}
