<%
/*
 * Copyright (c) Elastic Path Software Inc., 1999
 */
%>
<%@ page errorPage="error.jsp" buffer="500kb" autoFlush="false" %>
<%@ page import="com.elasticpath.commons.constants.PriceTierType" %>
<%@ page import="com.elasticpath.commons.datatransfer.CategoryDTO" %>
<%@ page import="com.elasticpath.commons.datatransfer.ProductDTO" %>
<%@ page import="com.elasticpath.commons.datatransfer.ProductVariationDTO" %>
<%@ page import="com.elasticpath.commons.datatransfer.ProductVariationAttributeDTO" %>
<%@ page import="com.elasticpath.dataaccess.hibernate.ProductVariationAttributeDAO" %>
<%@ page import="com.elasticpath.dataaccess.hibernate.ProductVariationDAO" %>
<%@ page import="com.elasticpath.dataaccess.hibernate.DAO" %>
<%@ page import="com.elasticpath.dataaccess.hibernate.ProductDAO" %>
<%@ page import="com.elasticpath.dataaccess.hibernate.CategoryDAO" %>
<%@ page import="com.elasticpath.commons.datatransfer.ProductCategoryDTO" %>
<%@ page import="com.elasticpath.dataaccess.hibernate.ProductCategoryDAO" %>
<%@ page import="com.elasticpath.commons.datatransfer.AttributeGroupDTO" %>
<%@ page import="com.elasticpath.dataaccess.hibernate.AttributeGroupDAO" %>
<%@ page import="com.elasticpath.commons.datatransfer.TaxCategoryDTO" %>
<%@ page import="com.elasticpath.dataaccess.hibernate.TaxCategoryDAO" %>
<%@ page import="com.elasticpath.commons.datatransfer.PriceTierDTO" %>
<%@ page import="com.elasticpath.dataaccess.hibernate.PriceTierDAO" %>
<%@ page import="com.elasticpath.dataaccess.hibernate.PriceTierAttributeDAO" %>
<%@ page import="com.elasticpath.commons.datatransfer.PriceTierAttributeDTO" %>
<%@ page import="com.elasticpath.commons.datatransfer.TaxCategoryDTO" %>
<%@ page import="com.elasticpath.dataaccess.hibernate.TaxCategoryDAO" %>
<%@ page import="com.elasticpath.commons.datatransfer.AttributeDTO" %>
<%@ page import="com.elasticpath.business.domain.ObjectAttributeBO" %>
<%@ page import="com.elasticpath.commons.comparator.ObjectAttributeDTOAttributeOrderingComparator"%>

<%@ page import="com.elasticpath.dataaccess.hibernate.HibernateUtilJNDI" %>

<%@ page import="com.elasticpath.commons.AttributeHelper" %>
<%@ page import="com.elasticpath.commons.constants.AttributeConstants"%>
<%@ page import="com.elasticpath.commons.constants.TaxConstants"%>
<%@ page import="com.elasticpath.commons.Utility" %>
<%@ page import="com.elasticpath.commons.Money" %>
<%@ page import="com.elasticpath.commons.RequestHelper" %>
<%@ page import="com.elasticpath.commons.exception.EPIllegalInputDataException" %>
<%@ page import="com.elasticpath.business.domain.PriceTierAttributeBO"%>
<%@ page import="com.elasticpath.business.domain.TransactionBO"%>
<%@ page import="com.elasticpath.business.domain.AttributeGroupBO"%>
<%@ page import="com.elasticpath.business.domain.ProductVariationBO"%>
<%@ page import="com.elasticpath.business.domain.ProductVariationAttributeBO"%>
<%@ page import="com.elasticpath.business.domain.PriceHelperBO"%>
<%@ page import="com.elasticpath.web.form.WebFormTool" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.util.*" %>
<%@ include file="includes/paths.jsp" %>
<%@ include file="includes/secure.jsp" %>



<%
    final String groupIDs = (String) session.getAttribute("groups");
	WebFormTool wf = new WebFormTool();	
	boolean isReadOnly=true;
	if(PermissionBO.askPermission(UserPermissionConstants.CATALOG_PV_EDIT, groupIDs))
	    isReadOnly=false;
	
	ProductVariationBO productVariationBO = new ProductVariationBO();
	ProductVariationAttributeBO productVariationAttributeBO = new ProductVariationAttributeBO();
	ProductCategoryDAO productCategoryDAO = new ProductCategoryDAO();
	PriceHelperBO priceHelperBO = new PriceHelperBO();
	ObjectAttributeBO objectAttributeBO = new ObjectAttributeBO();
	
	DAO dao = new DAO();
	AttributeGroupDAO attributeGroupDAO = new AttributeGroupDAO();
	PriceTierDAO priceTierDAO = new PriceTierDAO();
	CategoryDAO categoryDAO = new CategoryDAO();
	TaxCategoryDAO taxCategoryDAO = new TaxCategoryDAO();
	
	if (request.getParameter("pvUID")==null) throw new EPIllegalInputDataException ("The productVariation UID can't be null.");
	Integer pvUID = new Integer(Integer.parseInt(request.getParameter("pvUID")));
	ProductVariationDTO productVariationDTO = productVariationBO.getProductVariation(pvUID);
	if (productVariationDTO==null) throw new EPIllegalInputDataException("The specified productVariation can't be found.");

	String elementName = AttributeHelper.getObjectAttributeFormElementInitStr(productVariationDTO);
	
    ProductDTO  productDTO = productVariationDTO.getProduct();
	Integer attributeGroupID = productVariationDTO.getAttributeGroup().getUidPk(); 
	
	List productVariationAttributeList = productVariationAttributeBO.findProductVariationAttributeFullSet(productVariationDTO);
	
	String selected = "";
	int discountUID = 0;
	RequestHelper rh = new RequestHelper(request);
	ArrayList errorList = new ArrayList();
	
	if (request.getMethod().equalsIgnoreCase("post") && request.getParameter("btnDeletePV") != null) {
	    TransactionBO.beginTransaction();
       	boolean alldone=false;	    
	    try{
	    	productVariationBO.delete( productVariationDTO);
	    	TransactionBO.commitTransaction();
	        alldone=true;
	   }
	   finally {
	   		if (!alldone) {
		   		TransactionBO.rollbackTransaction();
	   		}
	   }
	    response.sendRedirect(securePath + "productVariation.jsp?prodUID=" + productDTO.getUidPk().intValue());
	}
	
	if (request.getMethod().equalsIgnoreCase("post") && request.getParameter("btnUpdatePV") != null) {
		
		//Validate the product variation fields
    	
          // Validation Checking
	      String name = ""+ request.getParameter("name");
	      String code =""+ request.getParameter("code");
	      //String price =""+ request.getParameter("price");
	      String weight =""+request.getParameter("shippingWeight");
	      
	      if(request.getParameter("trackInventory")!=null) {
		      String quantity = ""+ request.getParameter("quantity");
		      String reservedQuantity =""+ request.getParameter("reservedQuantity");
		      String reOrderMinQty =""+ request.getParameter("reOrderMinQty");
		      
		      if (quantity.length()>0){
		      	String value = quantity;
		      	try{
		
					Integer temp = new Integer(value);
					if (temp.toString().equalsIgnoreCase(value)){
					
					}else{
						errorList.add("\""+ value + "\" is not a valid value for quantity");
					}
					
				}catch(Exception e){
					errorList.add("\""+ value + "\" is not a valid value for quantity");
				}
		      
		      }
		      
		      if (reservedQuantity.length()>0){
		      	String value = reservedQuantity;
		      	try{
		
					Integer temp = new Integer(value);
					if (temp.toString().equalsIgnoreCase(value)){
					
					}else{
						errorList.add("\""+ value + "\" is not a valid value for Reserved Quantity");
					}
					
				}catch(Exception e){
					errorList.add("\""+ value + "\" is not a valid value for Reserved Quantity");
				}
		      
		      }
	
		      if (reOrderMinQty.length()>0){
		      	String value = reOrderMinQty;
		      	try{
		
					Integer temp = new Integer(value);
					if (temp.toString().equalsIgnoreCase(value)){
					
					}else{
						errorList.add("\""+ value + "\" is not a valid value for Reorder min. Quantity");
					}
					
				}catch(Exception e){
					errorList.add("\""+ value + "\" is not a valid value for Reorder min. Quantity");
				}
		      
		      }
	      }
	      
      	if (name.length()==0)
      		errorList.add("Product Variation Name is missing.");
      	if (code.length()==0 || code.trim().length() == 0) {
      		errorList.add("Code is missing.");
      	} else {
      		List tempPVList = productVariationBO.findByProductCode(code.trim());
      		if (tempPVList != null && tempPVList.size() > 0) { 
      			if (tempPVList.size() == 1) {
					ProductVariationDTO tempPVDTO = (ProductVariationDTO) tempPVList.get(0);
					if (tempPVDTO.getUidPk().intValue() != productVariationDTO.getUidPk().intValue()) {
						errorList.add("Product code " + code + " already exists.");
					} 
				} else { 
					errorList.add("Product code " + code + " already exists.");
				}
			}
      	}
      	
		if (weight.length()==0)
  			errorList.add("Weight is missing.");
     	else{
     		try{
				BigDecimal a = new BigDecimal(weight);
				String[] x = weight.split("\\.");
				if( x[0].length() >17)
				  	errorList.add(""+ weight + " is not a valid value for weight");
				}catch(Exception e){
					errorList.add(""+ weight + " is not a valid value for weight");
			}
		}
    
    	
		//Create the objectAttributeIDStr-To-Value map
        Enumeration names = request.getParameterNames();
        names = request.getParameterNames();
        final Map objectAttributeIDStrToValueMap=new HashMap();
        while (names.hasMoreElements()){
            String elementNamefromHTML = names.nextElement().toString();
            if (elementNamefromHTML.startsWith(elementName)) {
                objectAttributeIDStrToValueMap.put(elementNamefromHTML, request.getParameter(elementNamefromHTML));
            }
        }	
					        
        //Validate all Attributes from form post
        {
             final List errorMsg = AttributeHelper.validateAllAttributes( 
                    productVariationAttributeList,
                    objectAttributeIDStrToValueMap);
            if (errorMsg.size() > 0) { 
                errorList.addAll(errorMsg);
            }
        }
            	
    	if (!errorList.isEmpty()) {
            new RequestHelper(request).setErrors(errorList);
      } else {
      ///////////////PV info is changed, leave the old PV untouched, create a new PV record and copy all the related info
      ///////////////including: PriceTier, PVCGD, PVL, PVA, PVAG, PVAGT.  
		TransactionBO.beginTransaction();
       	boolean alldone=false;		
		try{
	      	pvUID = productVariationDTO.getUidPk();
	       	
	       	if (request.getParameter("disabled").equalsIgnoreCase("0"))
	       			productVariationDTO.setDisabled(false);
	       	else
	       			productVariationDTO.setDisabled(true);
	        
	        productVariationDTO.setProductCode(request.getParameter("code"));
	        productVariationDTO.setName(Utility.replaceDoubleQuotes(request.getParameter("name")));
	        //productVariationDTO.setPrice(new BigDecimal(request.getParameter("price")));
	        productVariationDTO.setShippingWeight(new BigDecimal(request.getParameter("shippingWeight")));
	        productVariationDTO.setShippingPackageType(request.getParameter("packageType"));
	     	if (request.getParameter("taxCategory").length()>0){
	     		TaxCategoryDTO tcDTO = new TaxCategoryDTO();
	     		tcDTO.setUidPk(new Integer(request.getParameter("taxCategory")));
	        	productVariationDTO.setTaxCategory(tcDTO);
	        }
	    	productVariationDTO.setTaxValue("0");
	      	if(request.getParameter("trackInventory")!=null) {
	     		productVariationDTO.setTrackInventory(true);
		        if (request.getParameter("quantity").length()>0)
		        	productVariationDTO.setStockCount(new Integer(request.getParameter("quantity")).intValue());
		        else
		        	productVariationDTO.setStockCount(0);
		        if (request.getParameter("reservedQuantity").length()>0)
		        	productVariationDTO.setReservedQty(new Integer(request.getParameter("reservedQuantity")).intValue());
		        else
		        	productVariationDTO.setReservedQty(0);
		        if (request.getParameter("reOrderMinQty").length()>0)
		        	productVariationDTO.setReOrderMinQty(new Integer(request.getParameter("reOrderMinQty")).intValue());
		 		else
		 			productVariationDTO.setReOrderMinQty(0);
		 	    if (request.getParameter("outOfStockVisible")!=null)
		       			productVariationDTO.setOutOfStockVisible(true);
		       	else
		       			productVariationDTO.setOutOfStockVisible(false);
	      	} else {
	      		productVariationDTO.setTrackInventory(false);
	     		productVariationDTO.setStockCount(0);
	     		productVariationDTO.setReservedQty(0);
	     		productVariationDTO.setReOrderMinQty(0);
	     		productVariationDTO.setOutOfStockVisible(true);
	      	}
	       	productVariationDTO.setAttributeGroup(attributeGroupDAO.load(new Integer(request.getParameter("attributeGroup"))));
	       	productVariationBO.update(productVariationDTO);
			(new ProductVariationAttributeDAO()).deleteByProductVariation(productVariationDTO.getUidPk());		
			
       		if (request.getMethod().equalsIgnoreCase("post")) {
       			productVariationAttributeList = dao.getFixedAttributeFullSet(productVariationDTO);
       			attributeGroupID = new Integer(request.getParameter("attributeGroup"));
       			productVariationAttributeList.addAll(dao.getAttributeFullSet(productVariationDTO, attributeGroupID));
       	        Collections.sort(productVariationAttributeList,new ObjectAttributeDTOAttributeOrderingComparator());
       		} 
			
			//Add all attributes from form post 
            {  		
                final String errorMsg = objectAttributeBO.addAllAttributes(productVariationDTO, 
                        productVariationAttributeList,
                        objectAttributeIDStrToValueMap);
                if (errorMsg.length() > 0) { 
                    errorList.add(errorMsg);
                }
            }
                        	
	        //attributeGroupID = productVariationAttributeGroupDTO.getAttributeGroup().getUidPk(); 
	    	//productVariationAttributeList = ProductVariationAttributeBO.findProductVariationAttribute (attributeGroupID, pvUID);
	    	TransactionBO.commitTransaction();
	        new RequestHelper(request).setConfirmation("Product Variation details have been saved successfully");
	    	response.sendRedirect(securePath + "productVariationDetail.jsp?pvUID=" + productVariationDTO.getUidPk().intValue());
	        alldone=true;
	   }
	   finally {
	   		if (!alldone) {
		   		TransactionBO.rollbackTransaction();
	   		}
	   }	    
     } // handle the update
        
    } 
    //delete price tiers
    if (request.getMethod().equalsIgnoreCase("post") && request.getParameter("btnDeletePTs") != null) {
        String[] ptUids = request.getParameterValues("deletePT");
        if (ptUids != null) {
        	TransactionBO.beginTransaction();
        	boolean alldone=false;        	
        	try{
	        	PriceTierDTO ptDTO = null;
	            for (int i = 0; i < ptUids.length; i++) {
	            	Integer pvID = new Integer(ptUids[i]);
	            	(new PriceTierAttributeDAO()).deleteByPriceTier(pvID);
	                ptDTO = priceTierDAO.load(pvID);
	                priceTierDAO.delete(ptDTO);
	            }
	            TransactionBO.commitTransaction();
		        alldone=true;
		   }
		   finally {
		   		if (!alldone) {
			   		TransactionBO.rollbackTransaction();
		   		}
		   }
        }
    }
    // get a sorted category attribute list -- attribute from the fixed group before those from the dynamic group
    
    if (request.getMethod().equalsIgnoreCase("post") && request.getParameter("btnDeletePTs") == null && request.getParameter("btnDeletePV") == null && request.getParameter("btnUpdatePV") == null) {
		productVariationAttributeList = dao.getFixedAttributeFullSet(productVariationDTO);
       	attributeGroupID = new Integer(request.getParameter("attributeGroup")); 
    	productVariationAttributeList.addAll(productVariationAttributeBO.findProductVariationAttribute (attributeGroupID, pvUID));
    } 
    CategoryDTO parentCategory = ((ProductCategoryDTO)productCategoryDAO.findByProductAll(productDTO.getUidPk()).get(0)).getCategory();
    ArrayList breadcrumbs = new ArrayList();
    breadcrumbs.add(0,parentCategory);
    while(parentCategory.getParentCategory()!=0){
    	parentCategory=categoryDAO.load(new Integer(parentCategory.getParentCategory()));
    	breadcrumbs.add(0,parentCategory);
    }
    breadcrumbs.add(productDTO);
    breadcrumbs.add(productVariationDTO);
    String breadcrumbAction = "Update Product Variation";
    
    String weightUnit = ep.getUnit("weight");
    String lengthUnit = ep.getUnit("length");
	TransactionBO.endSession();
%>
 

<%@ include file="includes/header.jsp" %>
<%@ include file="includes/catalogHeaderHib.jsp" %>
<link type="text/css" rel="StyleSheet" href="stylesheet/popupcal/popcalendar.css" />
<script type="text/javascript" src="js/popcalendar.js"></script>
<script src="js/util.js" type="text/javascript"></script>
             
              <table width="558" border="0" cellspacing="0" cellpadding="0">
                <tr class="mn-lv3">
                  <td valign="bottom"><div id="mn-lv3"><a href="productOverview.jsp?prodUID=<%= productDTO.getUidPk() %>">product overview</a> <a href="productVariation.jsp?prodUID=<%= productDTO.getUidPk() %>" class="on">variations/SKU's</a></div>
                  </td>
                </tr>
              </table>
              <script language="JavaScript1.2" src="js/select_all.js"></script>
              <form name="pofrm" method="post" action="productVariationDetail.jsp?pvUID=<%=productVariationDTO.getUidPk()%>">
                <div class="product-box">
                <% RequestHelper rh1 = new RequestHelper(request);
                    if (rh1.hasErrors()) {%>
                    <%@ include file="includes/errorMsgBox.jsp" %>
                <% } else if (rh.hasConfirmation()) {%>
                    <%@ include file="includes/confirmMsgBox.jsp" %>
                <% } %>
               	<table width="100%" border="0">                
                 	<tr><td><h1>Update Product Variation</h1></td><td align="right" valign="bottom">
		                <%=wf.authorizedContent().setUserGroups(groupIDs).setPermissions(UserPermissionConstants.CATALOG_PV_PROMOTION_VIEW).setHtmlElement(
                    	    wf.hyperLink().href("productVariationPromotion.jsp?pvUID="+productVariationDTO.getUidPk())
                    		.text("Manage Promotions")
                    		)
                        	%>
                 	</td></tr>
                </table>                  
                  <hr />
                  <table border="0" cellpadding="3" width="100%">
                    <col width="150" >
                    <col>
                    <tr valign="top">
                      <td>Status </td>
                      <td><select name="disabled">
                          <option value="0" <%= RequestHelper.formPopulate(request, "disabled", "0", productVariationDTO.isDisabled() ? "1" : "0", " selected") %>>enabled
                          <option value="1" <%= RequestHelper.formPopulate(request, "disabled", "1", productVariationDTO.isDisabled() ? "1" : "0", " selected") %>>disabled
                        </select>
                      </td>
                    </tr>
                    <tr valign="top">
                      <td>Code</td>
                      <td>
                            <input type="text" name="code" maxlength="100" size="47" value="<%= RequestHelper.formPopulate(request, "code", productVariationDTO.getProductCode()) %>">  <img src="images/icon_required.gif" alt="required" border="0">
                      </td>
                    </tr>
                    <tr valign="top">
                      <td>Name</td>
                      <td>
                            <input type="text" name="name" maxlength="100" size="47" value="<%= RequestHelper.formPopulate(request, "name", RequestHelper.displayNotNull(productVariationDTO.getName())) %>"> <img src="images/icon_required.gif" alt="required" border="0">
                      </td>
                    </tr>
                    <tr valign="top">
                      <td>Shipping Weight (<%=weightUnit%>)</td>
                      <td>
                            <input type="text" name="shippingWeight" maxlength="10" size="47" value="<%= RequestHelper.formPopulate(request, "shippingWeight", (productVariationDTO.getShippingWeight().toString())) %>"> <img src="images/icon_required.gif" alt="required" border="0">
                      </td>
                    </tr>
                    <input type="hidden" name="packageType" value="">
                    <!--tr valign="top">
                      <td>Shipping Package Type</td>
                      <td>
                          <input type="text" name="packageType" maxlength="3" size="47" value="<%= RequestHelper.formPopulate(request, "packageType", AttributeHelper.displayNotNull(""+productVariationDTO.getShippingPackageType())) %>">
                      </td>
                    </tr-->
                    <tr valign="top">
                      <td>Tax Category</td>
                      <td>
                        <select name="taxCategory">
                            <%
                                    List taxCategoryList = taxCategoryDAO.list();
                                    ListIterator taxCategoryListIterator = taxCategoryList.listIterator();
                                    while (taxCategoryListIterator.hasNext()) {
                                        TaxCategoryDTO currentTaxCategory = (TaxCategoryDTO)taxCategoryListIterator.next();
                                        if (currentTaxCategory.getName().equals(TaxConstants.TAX_CATEGORY_SHIPPING)) { 
                                        	continue;
                                        }
                            %>
                                    <option value="<%= currentTaxCategory.getUidPk() %>"<%= RequestHelper.formPopulate(request, "taxCategory", currentTaxCategory.getUidPk().toString(), (productVariationDTO.getTaxCategory()==null)?"":productVariationDTO.getTaxCategory().getUidPk().toString(),  " selected") %>><%= currentTaxCategory.getName() %>
                            <%      }       %>                            
                        </select>
                        <!--<a href="" onMouseOver="stm(Text[1],Style[1])" onMouseOut="htm()"><img src="images/icon_info.gif" alt="" width="13" height="13" border="0"></a> <a href="" onMouseOver="stm(Text[0],Style[0])" onMouseOut="htm()"><img src="images/icon_warning.gif" alt="" width="16" height="16" border="0"></a>--></td>
                    </tr>
                      <tr><td colspan="2">
                        <% boolean checkedTrackInventory = productVariationDTO.isTrackInventory();
                                    String checkTrackInventory;
                                        if (checkedTrackInventory){
                                        	checkTrackInventory = "checked=\"checked\"";
                                        }
                                        else{
                                        	checkTrackInventory = "";
                                        }
                        %>
                    	<h1>Track Inventory
                    	<input class="rad" type="checkbox" id="trackInventory" name="trackInventory" <%=checkTrackInventory%> onClick="toggleTrackInventory();">
                  		<a class="body" onmouseover="return overlib('<strong>NOTE:</strong> Disable Inventory Tracking for products with an infinite available quantity, e.g. Digital downloads & services.');" onmouseout="return nd();" href='#'><img border="0" src="images/help.gif" width="19" height="16"></a>
						</h1><hr />
                  		</td>
                  	</tr>
                  	<tbody id="ti">		          
                    <tr valign="top">
                      <td>Quantity</td>
                      <td>
                            <input type="text" name="quantity" id="quantity" maxlength="100" size="14" value="<%= RequestHelper.formPopulate(request, "quantity", Integer.toString(productVariationDTO.getStockCount())) %>">
                      </td>
                    </tr>
                    <tr valign="top">
                      <td>Reserved Quantity</td>
                      <td>
                            <input type="text" name="reservedQuantity" id="reservedQuantity" maxlength="100" size="14" value="<%= RequestHelper.formPopulate(request, "reserved quantity", Integer.toString(productVariationDTO.getReservedQty())) %>">
                      </td>
                    </tr>
                    <tr valign="top">
                      <td>Reorder min. Quantity</td>
                      <td>
                            <input type="text" name="reOrderMinQty" id="reOrderMinQty" maxlength="100" size="14" value="<%= RequestHelper.formPopulate(request, "reOrderMinQty", Integer.toString(productVariationDTO.getReOrderMinQty())) %>">
                      </td>
                    </tr>
                   <tr valign="top">
                      <td>Out of Stock Visible</td>
                      <td>
                              <% boolean checkedOutOfStock = productVariationDTO.isOutOfStockVisible();
                                    String checkOutOfStock;
                                        if (checkedOutOfStock){
                                           checkOutOfStock = "checked=\"checked\"";
                                        }
                                        else{
                                            checkOutOfStock = "";
                                        }
                               %>
                             <input class="checkbox" type="checkbox" name="outOfStockVisible" id="outOfStockVisible" <%=checkOutOfStock%>>
                      </td>
                   </tr>                   
                  </tbody>
                  </table>
                 
                <br>
               
                <table width="100%" border="0">                
                 	<tr><td><h1>Attribute Group</h1></td></tr>
                </table> 
                   <hr />
                   
                   <table border="0" cellpadding="3" width="100%">
                    <col width="150" >
                    <col>
                                    
                      <td>Attribute Groups </td>
                      <td>
                        <select name="attributeGroup" onchange="document.pofrm.submit();">
<%
    List attributeGroupDTOList = attributeGroupDAO.findAllPV();
    ListIterator agDTOIterator = attributeGroupDTOList.listIterator();
    while (agDTOIterator.hasNext()) {
        AttributeGroupDTO currentAG = (AttributeGroupDTO)agDTOIterator.next();
        selected = "";
        if (currentAG.getUidPk().intValue() == attributeGroupID.intValue() ) {
            selected = "SELECTED";
        }
%>
                            <option value="<%= currentAG.getUidPk().intValue() %>" <%= selected %> ><%= currentAG.getName() %></option>
<%
    }
%>
                        </select>
                  </td>
               </table>
                
                
                
               <table width="100%" border="0">                
                 	<tr><td><h1>Product Variation Attributes</h1></td></tr>
                </table>                  
                  <hr />  
                
                <table border="0" cellpadding="3" width="100%">
                    <col width="150" >
                    <col>
                    <%   ProductVariationAttributeDTO currentPVAttribute = new ProductVariationAttributeDTO();
                         for (int i = 0; i < productVariationAttributeList.size(); i ++){                          
                           currentPVAttribute = (ProductVariationAttributeDTO)productVariationAttributeList.get(i);                 
                           
					%>
                    <tr><%
                    	String attrKey = currentPVAttribute.getAttribute().getAttributeKey();
                    	if (attrKey.equalsIgnoreCase(AttributeConstants.ATTRIBUTE_KEY_PRODUCTVARIATION_SHIPPING_HEIGHT) || 
                    	attrKey.equalsIgnoreCase(AttributeConstants.ATTRIBUTE_KEY_PRODUCTVARIATION_SHIPPING_LENGTH) || 
                    	attrKey.equalsIgnoreCase(AttributeConstants.ATTRIBUTE_KEY_PRODUCTVARIATION_SHIPPING_WIDTH)){ 
                    %>
                       <td valign="top"><%= AttributeHelper.getAttributeFullName(currentPVAttribute)%> (<%=lengthUnit%>) </td>
                       <%}else{%>
                       <td valign="top"><%= AttributeHelper.getAttributeFullName(currentPVAttribute)%></td>
					   <%}%>
                       <td nowrap>
    					<%=AttributeHelper.toJSPElementHTMLCode(productVariationDTO, currentPVAttribute, RequestHelper.formPopulate(request, AttributeHelper.getObjectAttributeFormElementName(productVariationDTO, currentPVAttribute), currentPVAttribute.getValue()),true,isReadOnly)%>
                       </td>
						<td> 
						<!-- the td here is to make sure the displaying of the textarea attributes with required flag set is correct.-->
						&nbsp;&nbsp;
						</td>                       
                    </tr>
                    <%
                        	} //end while
                    %>
                 </table>
                <br>
                
                
                
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td>
                    	<%=wf.authorizedContent().setUserGroups(groupIDs).setPermissions(UserPermissionConstants.CATALOG_PV_DELETE).setHtmlElement(
                        	    wf.button().clazz("warn-btn").type("submit").name("btnDeletePV").value("Delete Product Variation")
                        	    .onClick("return confirm('Are you sure you want to delete this product variation?');")
                        	    )
                        	%>
                    </td>
                    <td>&nbsp;</td>
                    <td align="right">
                      <input type="hidden" name="pvUID" value="<%= productVariationDTO.getUidPk() %>">
                        	<%=wf.authorizedContent().setUserGroups(groupIDs).setPermissions(UserPermissionConstants.CATALOG_PV_EDIT).setHtmlElement(
                        	    wf.button().clazz("btn").type("submit").name("btnUpdatePV")
                        	    	.id("btnUpdatePV").value("Save Product Variation")
                        	    )
                        	%>
                    </td>
                  </tr>
                </table>
                  <h1>Update Price Tiers</h1>
                  <hr />
                  <table class="grid" border="0" cellpadding="3" cellspacing="0" width="100%" slcolor="#eeeeee" hlcolor="#EEEEEE">
                      <colgroup>
                      <col align="center" width="70" nowrap="nowrap">
                      <col width="65">
                      <col>
                      <col>
                      <col>
                      <col>
                      </colgroup>
                      <thead>
                        <tr class="mnubar">
                          <td>Select All</td>
                          <td>Action</td>
                          <td>Qty >=</td>
                          <td>Type</td>
                          <td>Amount</td>
                          <td>Disabled</td>
                        </tr>
                      </thead>
                        <tr bgcolor="#E5E5E5">
                          <td><input class="rad" type="checkbox" id="SelectALL" name="SelectALL" onClick="doselectAll(this, 'SelectALL')"></td>
                          <td>
		                <%=wf.authorizedContent().setUserGroups(groupIDs).setPermissions(UserPermissionConstants.CATALOG_PV_PRICETIER_ADD).setHtmlElement(
                    	    wf.hyperLink().href("javascript:openScrollableWindow('priceTierAdd.jsp?pvUID="+pvUID.toString()+"', '', '600', '400');")
                    		.img(wf.img().src("images/icon_create.gif").vspace(2).border(0))
                    		)
                        	%>
                          </td>
                          <td colspan="4">Click create to add a new price tier</td>
                        </tr>
                        <%
                            List priceTiers = priceTierDAO.findByPVID(pvUID, true);
                            ListIterator priceTierIterator = priceTiers.listIterator();
                            while (priceTierIterator.hasNext()) {
                                PriceTierDTO currentTier = (PriceTierDTO)priceTierIterator.next();
                        %>
                        <tr valign="top">
                            <td><input type="checkbox" id="SelectALL" class="rad" name="deletePT" value="<%= currentTier.getUidPk() %>"></td>
                            <td>
		                <%=wf.authorizedContent().setUserGroups(groupIDs).setPermissions(UserPermissionConstants.CATALOG_PV_PRICETIER_EDIT).setHtmlElement(
                    	    wf.hyperLink().href("javascript:openScrollableWindow('priceTierUpdate.jsp?ptUID="+currentTier.getUidPk()+"', '', '600', '400');")
                    		.img(wf.img().src("images/icon_edit.gif").vspace(2).border(0))
                    		)
                        	%>           
                            </td>
                            <td><%= currentTier.getMinimumQuantity() %></td>
                            <td><%= currentTier.getType().trim().equalsIgnoreCase(PriceTierType.PERCENTAGE)? "% off" : "$ off" %></td>
                            <td>
                            <%if (currentTier.getType().equalsIgnoreCase(PriceTierType.PERCENTAGE)){%>
								<%= currentTier.getAmount().toString()%>
							<%}else{%>
                            	<%= priceHelperBO.getPriceDisplayStr(currentTier, AttributeConstants.ATTRIBUTE_KEY_PRICE_TIER_AMOUNT)%>
							<%}%>
							</td>
							<td>
							<%if (currentTier.isDisabled()){%>
								Yes
							<%}else{%>
								No
							<%}%>
							</td>
                        </tr>                                
                        <%  }   %>
                      <tbody>
                      </tbody>
                  </table>
                  <br>
                  	<%if (priceTiers.size() > 0 ) { %>
                    	<%=wf.authorizedContent().setUserGroups(groupIDs).setPermissions(UserPermissionConstants.CATALOG_PV_PRICETIER_DELETE).setHtmlElement(
                        	    wf.button().clazz("warn-btn").type("submit").name("btnDeletePTs").value("Delete Selected Price Tiers")
                        	    .onClick("return confirm('Are you sure you want to delete selected price tiers?');")
                        	    )
                        	%>             
                    <% } %>
                </div>
              </form>
              
<%TransactionBO.endSession();%>
<%if(!checkedTrackInventory) {
	out.println("<script type=\"text/javascript\">toggleTrackInventory();</script>");
}                  		
%>
<%@ include file="includes/catalogFooter.jsp" %>
<%@ include file="includes/footer.jsp" %>