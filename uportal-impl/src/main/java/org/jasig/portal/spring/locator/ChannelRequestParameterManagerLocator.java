/**
 * Copyright (c) 2000-2009, Jasig, Inc.
 * See license distributed with this file and available online at
 * https://www.ja-sig.org/svn/jasig-parent/tags/rel-10/license-header.txt
 */
package org.jasig.portal.spring.locator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.portal.spring.PortalApplicationContextLocator;
import org.jasig.portal.url.support.IChannelRequestParameterManager;
import org.springframework.context.ApplicationContext;

/**
 * @author Eric Dalquist
 * @version $Revision$
 * @deprecated code that needs an IChannelRequestParameterManager should use direct dependency injection where possible
 */
@Deprecated
public class ChannelRequestParameterManagerLocator extends AbstractBeanLocator<IChannelRequestParameterManager> {
    public static final String BEAN_NAME = "channelRequestParameterManager";
    
    private static final Log LOG = LogFactory.getLog(ChannelRequestParameterManagerLocator.class);
    private static AbstractBeanLocator<IChannelRequestParameterManager> locatorInstance;

    public static IChannelRequestParameterManager getChannelRequestParameterManager() {
        AbstractBeanLocator<IChannelRequestParameterManager> locator = locatorInstance;
        if (locator == null) {
            LOG.info("Looking up bean '" + BEAN_NAME + "' in ApplicationContext due to context not yet being initialized");
            final ApplicationContext applicationContext = PortalApplicationContextLocator.getApplicationContext();
            applicationContext.getBean(ChannelRequestParameterManagerLocator.class.getName());
            
            locator = locatorInstance;
            if (locator == null) {
                LOG.warn("Instance of '" + BEAN_NAME + "' still null after portal application context has been initialized");
                return (IChannelRequestParameterManager)applicationContext.getBean(BEAN_NAME, IChannelRequestParameterManager.class);
            }
        }
        
        return locator.getInstance();
    }

    public ChannelRequestParameterManagerLocator(IChannelRequestParameterManager instance) {
        super(instance, IChannelRequestParameterManager.class);
    }

    /* (non-Javadoc)
     * @see org.jasig.portal.spring.locator.AbstractBeanLocator#getLocator()
     */
    @Override
    protected AbstractBeanLocator<IChannelRequestParameterManager> getLocator() {
        return locatorInstance;
    }

    /* (non-Javadoc)
     * @see org.jasig.portal.spring.locator.AbstractBeanLocator#setLocator(org.jasig.portal.spring.locator.AbstractBeanLocator)
     */
    @Override
    protected void setLocator(AbstractBeanLocator<IChannelRequestParameterManager> locator) {
        locatorInstance = locator;
    }
}