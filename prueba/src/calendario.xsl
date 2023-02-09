<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>	
	<head>
		<title>Calendario</title>
		<link type="text/css" rel="stylesheet" href="calendario.css"/>
	</head>
	<body>
		<table>
			<tr>
			<th>Lunes</th>
			<th>Martes</th>
			<th>Miércoles</th>
			<th>Jueves</th>
			<th>Viernes</th>
			<th>Sábado</th>
			<th>Domingo</th>
			</tr>
			<xsl:for-each select="calendario/mes/semana">
				<tr>
				<xsl:for-each select="dia">
					<xsl:variable name="x" select="."/>
					<xsl:variable name="y" select="position()"/>
					<xsl:choose>
						<xsl:when test="$y = 7">
							<td class="red"><xsl:value-of select="@id"/></td>		
						</xsl:when>	
						<xsl:when test="$x = ''">
							<td class="grey"><xsl:value-of select="@id"/></td>
						</xsl:when>
						<xsl:otherwise>
							<td class="blue" title="{$x}"><xsl:value-of select="@id"/></td>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:for-each>
				</tr>
			</xsl:for-each>
		</table>
	</body>
</html>
</xsl:template>
</xsl:stylesheet>