package com.softtech.galaxyairservices.Models;

public class GetterSetter {

    int id;

    int userGroupId;
    int userId;
    String userCLientId;
    int userOrganizationId;

    int hotel_id;
    int organization_id;
    int group_id;
    String bankAccountNumber;
    String email;
    String image;
    String registrationDate;
    String mobile;
    String cnic;
    String clientId;
    String email_verified_at;
    String password;
    String remember_token;
    String groupName;
    String user_type;
    String name;

    String paid_amount;
    String remaining_amount;
    String total_amount;

    String userGroupName;
    String userName;
    String userEmail;
    String userMobile;
    String userCNIC;
    String organizationName;
    String hotel_name;
    String city_name;
    String latitude;
    String longitude;
    String kilometers;
    String hotel_pic;
    String created_at;
    String updated_at;

    public GetterSetter(int int_id, int int_organization_id, int int_group_id, int int_hotel_id, String str_name, String str_email, String str_mobile, String str_cnic, String str_clientId, String str_bankAccountNumber, String str_image, String str_registrationDate, String str_email_verified_at,
                        String str_password, String str_remember_token, String str_user_type, String str_groupName, String str_created_at, String str_updated_at) {

        this.id = int_id;
        this.organization_id = int_organization_id;
        this.group_id = int_group_id;
        this.hotel_id = int_hotel_id;
        this.name = str_name;
        this.email = str_email;
        this.mobile = str_mobile;
        this.cnic = str_cnic;
        this.clientId = str_clientId;
        this.bankAccountNumber = str_bankAccountNumber;
        this.image = str_image;
        this.registrationDate = str_registrationDate;
        this.email_verified_at = str_email_verified_at;
        this.password = str_password;
        this.remember_token = str_remember_token;
        this.user_type = str_user_type;
        this.groupName = str_groupName;
        this.created_at = str_created_at;
        this.updated_at = str_updated_at;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(int userGroupId) {
        this.userGroupId = userGroupId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserCLientId() {
        return userCLientId;
    }

    public void setUserCLientId(String userCLientId) {
        this.userCLientId = userCLientId;
    }

    public int getUserOrganizationId() {
        return userOrganizationId;
    }

    public void setUserOrganizationId(int userOrganizationId) {
        this.userOrganizationId = userOrganizationId;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public int getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(int organization_id) {
        this.organization_id = organization_id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getEmail_verified_at() {
        return email_verified_at;
    }

    public void setEmail_verified_at(String email_verified_at) {
        this.email_verified_at = email_verified_at;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemember_token() {
        return remember_token;
    }

    public void setRemember_token(String remember_token) {
        this.remember_token = remember_token;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaid_amount() {
        return paid_amount;
    }

    public void setPaid_amount(String paid_amount) {
        this.paid_amount = paid_amount;
    }

    public String getRemaining_amount() {
        return remaining_amount;
    }

    public void setRemaining_amount(String remaining_amount) {
        this.remaining_amount = remaining_amount;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getUserGroupName() {
        return userGroupName;
    }

    public void setUserGroupName(String userGroupName) {
        this.userGroupName = userGroupName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserCNIC() {
        return userCNIC;
    }

    public void setUserCNIC(String userCNIC) {
        this.userCNIC = userCNIC;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getKilometers() {
        return kilometers;
    }

    public void setKilometers(String kilometers) {
        this.kilometers = kilometers;
    }

    public String getHotel_pic() {
        return hotel_pic;
    }

    public void setHotel_pic(String hotel_pic) {
        this.hotel_pic = hotel_pic;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }



}
