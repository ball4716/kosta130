<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<!-- XML데이터에 대한 스타일을 정의!! -->
	<xsl:template match="/persons">
		<!-- template : 스타일 정의 단위 -->
		<html>
		<body>
		<center>
			<table cellpadding="5">
				<tr bgcolor='yellow'>
					<th>이름</th>
					<th>나이</th>
					<th>직업</th>
				</tr>
				<xsl:apply-templates/><!-- 자식요소에 대한 템플릿호출 -->
			</table>
		</center>
	</xsl:template>
	
	<xsl:template match="person">
		<tr>
		
		</tr>
	</xsl:template>
	
	<xsl:template match="name">
		<td>
			<xsl:value-of select="."/>
		</td>
	</xsl:template>
	
	<xsl:template match="age">
		<td>
			<xsl:value-of select="."/>
		</td>
	</xsl:template>
	
	<xsl:template match="job">
		<td>
			<xsl:value-of select="."/>
		</td>
	</xsl:template>
</xsl:stylesheet>