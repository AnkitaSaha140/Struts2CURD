<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="menu.jsp"></jsp:include>
<html>
    <head>
        <title>Report</title>
        <style>
            table, td, th {border: 1px solid black;}
            table {border-collapse: collapse;width: 60%;}
            th {height: 30px;}
            .button-update {background-color: #008CBA;color: white;}
            .button-delete {background-color: red;color: white;}
        </style>
    </head>
    <body>
        <h2>Simple CURD Using STRUTS2 FRAMEWORK</h2>
        <div style="margin-top: 40px;">
            <s:if test="noData==false">
                <table>
                    <thead>
                        <tr style="background-color: #E0E0E1;">
                            <th>User Name</th>
                            <th>Password</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email</th>
                            <th>Phone Number</th>
                        </tr>
                    </thead>
                    <s:iterator value="userList">
                        <tr>
                        <td><s:property value="userName" /></td>
                        <td><s:property value="password" /></td>
                        <td><s:property value="firstName" /></td>
                        <td><s:property value="lastName" /></td>
                        <td><s:property value="email" /></td>
                        <td><s:property value="phoneNumber" /></td>
                        <td>
                            <a href="updatedetails.action?submitType=updatedata&userName=<s:property value="userName"/>">
                               <button class="button-update">Update</button>
                            </a>
                            <a href="deleterecord.action?userName=<s:property value="userName"/>">
                               <button class="button-delete">Delete</button>
                            </a>
                        </td>
                        </tr>
                    </s:iterator>
                </table>
            </s:if>
            <s:else>
                <div style="color: red;">No Data Found.</div>
            </s:else>
        </div>
    </body>
</html>