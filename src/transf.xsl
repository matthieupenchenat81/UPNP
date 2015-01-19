<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:service="urn:schemas-upnp-org:service-1-0" xmlns:device="urn:schemas-upnp-org:device-1-0">

	<xsl:output method="xml" indent="yes"/>
	
	<xsl:template match="service:action">
	<xsl:text disable-output-escaping='yes'>&lt;!DOCTYPE device SYSTEM "device.dtd"></xsl:text>
	
		<xsl:apply-templates/>
			
	</xsl:template>

</xsl:stylesheet>


