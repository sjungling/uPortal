/**
 * 
 */
package org.jasig.portal.portlet.container.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.container.PortletActionResponseContext;
import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletEventResponseContext;
import org.apache.pluto.container.PortletRenderResponseContext;
import org.apache.pluto.container.PortletRequestContext;
import org.apache.pluto.container.PortletRequestContextService;
import org.apache.pluto.container.PortletResourceRequestContext;
import org.apache.pluto.container.PortletResourceResponseContext;
import org.apache.pluto.container.PortletWindow;
import org.jasig.portal.portlet.container.PortletActionResponseContextImpl;
import org.jasig.portal.portlet.container.PortletEventResponseContextImpl;
import org.jasig.portal.portlet.container.PortletRenderResponseContextImpl;
import org.jasig.portal.portlet.container.PortletRequestContextImpl;
import org.jasig.portal.portlet.container.PortletResourceRequestContextImpl;
import org.jasig.portal.portlet.container.PortletResourceResponseContextImpl;
import org.jasig.portal.portlet.container.properties.IRequestPropertiesManager;
import org.jasig.portal.portlet.om.IPortletWindow;
import org.jasig.portal.portlet.registry.IPortletWindowRegistry;
import org.jasig.portal.url.IPortalUrlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Nicholas Blair, npblair@wisc.edu
 *
 */
@Service("portletRequestContextService")
public class LocalPortletRequestContextServiceImpl implements PortletRequestContextService {
    private IPortletWindowRegistry portletWindowRegistry;
    private IRequestPropertiesManager requestPropertiesManager;
    private IPortalUrlProvider portalUrlProvider;

    @Autowired
	public void setPortletWindowRegistry(IPortletWindowRegistry portletWindowRegistry) {
        this.portletWindowRegistry = portletWindowRegistry;
    }

    @Autowired
    public void setRequestPropertiesManager(IRequestPropertiesManager requestPropertiesManager) {
        this.requestPropertiesManager = requestPropertiesManager;
    }

    @Autowired
    public void setPortalUrlProvider(IPortalUrlProvider portalUrlProvider) {
        this.portalUrlProvider = portalUrlProvider;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.container.PortletRequestContextService#getPortletActionRequestContext(org.apache.pluto.container.PortletContainer, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.apache.pluto.container.PortletWindow)
	 */
	@Override
	public PortletRequestContext getPortletActionRequestContext(
			PortletContainer container, HttpServletRequest containerRequest,
			HttpServletResponse containerResponse, PortletWindow window) {
	    
	    final IPortletWindow portletWindow = this.portletWindowRegistry.convertPortletWindow(containerRequest, window);
	    return new PortletRequestContextImpl(container, portletWindow, containerRequest, containerResponse, this.requestPropertiesManager);
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.container.PortletRequestContextService#getPortletActionResponseContext(org.apache.pluto.container.PortletContainer, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.apache.pluto.container.PortletWindow)
	 */
	@Override
	public PortletActionResponseContext getPortletActionResponseContext(
			PortletContainer container, HttpServletRequest containerRequest,
			HttpServletResponse containerResponse, PortletWindow window) {
	    
	    final IPortletWindow portletWindow = this.portletWindowRegistry.convertPortletWindow(containerRequest, window);
        return new PortletActionResponseContextImpl(container, portletWindow, containerRequest, containerResponse, requestPropertiesManager, this.portalUrlProvider);
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.container.PortletRequestContextService#getPortletEventRequestContext(org.apache.pluto.container.PortletContainer, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.apache.pluto.container.PortletWindow)
	 */
	@Override
	public PortletRequestContext getPortletEventRequestContext(
			PortletContainer container, HttpServletRequest containerRequest,
			HttpServletResponse containerResponse, PortletWindow window) {
	    
        final IPortletWindow portletWindow = this.portletWindowRegistry.convertPortletWindow(containerRequest, window);
        return new PortletRequestContextImpl(container, portletWindow, containerRequest, containerResponse, this.requestPropertiesManager);
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.container.PortletRequestContextService#getPortletEventResponseContext(org.apache.pluto.container.PortletContainer, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.apache.pluto.container.PortletWindow)
	 */
	@Override
	public PortletEventResponseContext getPortletEventResponseContext(
			PortletContainer container, HttpServletRequest containerRequest,
			HttpServletResponse containerResponse, PortletWindow window) {
		
	    final IPortletWindow portletWindow = this.portletWindowRegistry.convertPortletWindow(containerRequest, window);
        return new PortletEventResponseContextImpl(container, portletWindow, containerRequest, containerResponse, requestPropertiesManager, this.portalUrlProvider);
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.container.PortletRequestContextService#getPortletRenderRequestContext(org.apache.pluto.container.PortletContainer, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.apache.pluto.container.PortletWindow)
	 */
	@Override
	public PortletRequestContext getPortletRenderRequestContext(
			PortletContainer container, HttpServletRequest containerRequest,
			HttpServletResponse containerResponse, PortletWindow window) {

	    final IPortletWindow portletWindow = this.portletWindowRegistry.convertPortletWindow(containerRequest, window);
        return new PortletRequestContextImpl(container, portletWindow, containerRequest, containerResponse, this.requestPropertiesManager);
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.container.PortletRequestContextService#getPortletRenderResponseContext(org.apache.pluto.container.PortletContainer, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.apache.pluto.container.PortletWindow)
	 */
	@Override
	public PortletRenderResponseContext getPortletRenderResponseContext(
			PortletContainer container, HttpServletRequest containerRequest,
			HttpServletResponse containerResponse, PortletWindow window) {
	    
	    final IPortletWindow portletWindow = this.portletWindowRegistry.convertPortletWindow(containerRequest, window);
	    return new PortletRenderResponseContextImpl(container, portletWindow, containerRequest, containerResponse, this.requestPropertiesManager, this.portalUrlProvider);
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.container.PortletRequestContextService#getPortletResourceRequestContext(org.apache.pluto.container.PortletContainer, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.apache.pluto.container.PortletWindow)
	 */
	@Override
	public PortletResourceRequestContext getPortletResourceRequestContext(
			PortletContainer container, HttpServletRequest containerRequest,
			HttpServletResponse containerResponse, PortletWindow window) {
	    final IPortletWindow portletWindow = this.portletWindowRegistry.convertPortletWindow(containerRequest, window);
        return new PortletResourceRequestContextImpl(container, portletWindow, containerRequest, containerResponse, this.requestPropertiesManager);
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.container.PortletRequestContextService#getPortletResourceResponseContext(org.apache.pluto.container.PortletContainer, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.apache.pluto.container.PortletWindow)
	 */
	@Override
	public PortletResourceResponseContext getPortletResourceResponseContext(
			PortletContainer container, HttpServletRequest containerRequest,
			HttpServletResponse containerResponse, PortletWindow window) {

	    final IPortletWindow portletWindow = this.portletWindowRegistry.convertPortletWindow(containerRequest, window);
        
		return new PortletResourceResponseContextImpl(container, portletWindow, containerRequest, containerResponse, this.requestPropertiesManager, this.portalUrlProvider);
	}
}