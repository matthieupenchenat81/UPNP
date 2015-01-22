<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:service="urn:schemas-upnp-org:service-1-0" xmlns:device="urn:schemas-upnp-org:device-1-0">

	<xsl:output method="xml" indent="yes"/>
	
	<xsl:template match="/">
	<xsl:text disable-output-escaping='yes'>&lt;!DOCTYPE device SYSTEM "device.dtd"></xsl:text>
		<device>
			<xsl:apply-templates select="document('description.xml')//device:deviceType"/>
			<xsl:apply-templates select="document('description.xml')//device:friendlyName"/>
			<xsl:apply-templates select="document('description.xml')//device:manufacturerURL"/>
			<xsl:apply-templates select="document('description.xml')//device:modelDescription"/>
			<xsl:apply-templates select="document('description.xml')//device:modelName"/>
			<xsl:apply-templates select="document('description.xml')//device:modelURL"/>
			<xsl:apply-templates select="document('description.xml')//device:modelNumber"/>
			<xsl:apply-templates select="document('description.xml')//device:urlBase"/>
			<xsl:apply-templates select="document('description.xml')//device:UDN"/>
			<xsl:apply-templates select="document('description.xml')//device:deviceType"/>
			<xsl:apply-templates select="document('description.xml')//device:service"/>
		</device>
	</xsl:template>
	
	<xsl:template match="device:service">
		<service>
			<xsl:apply-templates/>
			<xsl:for-each select="document('service.xml')//service:action">
				<action>
					<name>
						<xsl:apply-templates select="service:name"/>
					</name>
					<xsl:apply-templates select="//service:argument"/>
				</action>
			</xsl:for-each>
		</service>
	</xsl:template>
	
	<xsl:template match="service:argument">
		<argument>
			<returnValue><xsl:value-of select="service:relatedStateVariable"/></returnValue>
			<name><xsl:value-of select="service:name"/></name>
			<direction><xsl:value-of select="service:direction"/></direction>
			<value><xsl:value-of select="service:value"/></value>
		</argument>
	</xsl:template>
	
	<xsl:template match="device:serviceType">
		<serviceType>
			<xsl:apply-templates/>
		</serviceType>
	</xsl:template>
	
	<xsl:template match="device:controlURL">
		<controlURL>
			<xsl:apply-templates/>
		</controlURL>
	</xsl:template>
	
	<xsl:template match="device:manufacturerURL">
		<manufacturerURL>
			<xsl:apply-templates/>
		</manufacturerURL>
	</xsl:template>
	
	<xsl:template match="device:serviceId">
		<serviceID>
			<xsl:apply-templates/>
		</serviceID>
	</xsl:template>
	
	<xsl:template match="device:eventSubURL">
		<eventSubURL>
			<xsl:apply-templates/>
		</eventSubURL>
	</xsl:template>
	
	<xsl:template match="device:SCPDURL">
		<descriptionURL>
			<xsl:apply-templates/>
		</descriptionURL>
	</xsl:template>



	<xsl:template match="device:deviceType">
		<deviceType>
			<xsl:apply-templates/>
		</deviceType>
	</xsl:template>
	
	<xsl:template match="device:friendlyName">
		<friendlyName>
			<xsl:apply-templates/>
		</friendlyName>
	</xsl:template>
	
	<xsl:template match="device:manufactuerURL">
		<manufactuerURL>
			<xsl:apply-templates/>
		</manufactuerURL>
	</xsl:template>
	
	<xsl:template match="device:modelDescription">
		<modelDescription>
			<xsl:apply-templates/>
		</modelDescription>
	</xsl:template>
	
	<xsl:template match="device:modelName">
		<modelName>
			<xsl:apply-templates/>
		</modelName>
	</xsl:template>
	
	<xsl:template match="device:modelURL">
		<modelUrl>
			<xsl:apply-templates/>
		</modelUrl>
	</xsl:template>
	
	<xsl:template match="device:modelNumber">
		<serialNumber>
			<xsl:apply-templates/>
		</serialNumber>
	</xsl:template>
	
	<xsl:template match="device:urlBase">
		<urlBase>
			<xsl:apply-templates/>
		</urlBase>
	</xsl:template>
	
	<xsl:template match="device:UDN">
		<presentationUrl>
			<xsl:apply-templates/>
		</presentationUrl>
	</xsl:template>
	
	<xsl:template match="device:deviceType">
		<descriptionUrl>
			<xsl:apply-templates/>
		</descriptionUrl>
	</xsl:template>

</xsl:stylesheet>


