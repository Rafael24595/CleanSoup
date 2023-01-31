package io.configuration.entities.receiver;

import io.configuration.entities.receiver.interfaces.IModule;
import io.configuration.entities.receiver.interfaces.ISystem;
import io.configuration.exception.ConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import static io.configuration.tools.XmlTools.getTagElement;

class AbstractDocumentSystem extends AbstractDocumentModule {

    private static final String SYSTEM = "system";

    protected ISystem module;

    protected AbstractDocumentSystem(Document document) {
        super(document);
    }

    protected void buildDocument(Class<? extends IModule> clazz, String tag) throws ConfigurationException {
        Element moduleElementTag = getModuleTagElement(tag);
        this.module = buildModule(clazz, moduleElementTag);
    }

    protected <T extends core.java.module.IModule> T getInstance() throws ConfigurationException {
        if(module == null)
            return null;
        return module.getInstance();
    }

    protected Element getModuleTagElement(String tag){
        Element inputTag = getTagElement(document, SYSTEM);
        return getTagElement(inputTag, tag);
    }

}