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
                            <th>Product Id</th>
                            <th>Product Name</th>
                            <th>Product Make</th>
                            <th>Price</th>
                            <th>Availability</th>
                           
                        </tr>
                    </thead>
                    <s:iterator value="productList">
                        <tr>
                        <td><s:property value="productId" /></td>
                        <td><s:property value="productName" /></td>
                        <td><s:property value="productMake" /></td>
                        <td><s:property value="price" /></td>
                        <td><s:property value="availability" /></td>
                       
                        <td>
                            <a href="updateproductdetails.action?submitType=updateproductsdata&productId=<s:property value="productId"/>">
                               <button class="button-update">Update</button>
                            </a>
                            <a href="deleteproductrecord.action?productId=<s:property value="productId"/>">
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