{"id":"c2c5a59c-139c-4e0e-a6d3-00694519362c","name":"com_byoskill_pretimmo_DemandePretDO","model":{"source":"INTERNAL","className":"com.byoskill.pretimmo.DemandePretDO","name":"DemandePretDO","properties":[{"name":"conditionsFinancieresDO","typeInfo":{"type":"OBJECT","className":"com.byoskill.pretimmo.ConditionsFinancieresDO","multiple":false},"metaData":{"entries":[{"name":"field-label","value":"conditionsFinancieresDO"},{"name":"field-placeHolder","value":"conditionsFinancieresDO"}]}},{"name":"processId","typeInfo":{"type":"BASE","className":"java.lang.Long","multiple":false},"metaData":{"entries":[{"name":"field-label","value":"processId"},{"name":"field-placeHolder","value":"processId"}]}},{"name":"id","typeInfo":{"type":"BASE","className":"java.lang.Long","multiple":false},"metaData":{"entries":[{"name":"field-label","value":"id"},{"name":"field-placeHolder","value":"id"}]}},{"name":"status","typeInfo":{"type":"BASE","className":"java.lang.String","multiple":false},"metaData":{"entries":[{"name":"field-label","value":"status"},{"name":"field-placeHolder","value":"status"}]}}],"formModelType":"org.kie.workbench.common.forms.data.modeller.model.DataObjectFormModel"},"fields":[{"nestedForm":"c3dde9c2-99bd-4536-a006-c796a9d615be","container":"FIELD_SET","id":"field_410823013926966E12","name":"conditionsFinancieresDO","label":"conditionsFinancieresDO","required":false,"readOnly":false,"validateOnChange":true,"binding":"conditionsFinancieresDO","standaloneClassName":"com.byoskill.pretimmo.ConditionsFinancieresDO","code":"SubForm","serializedFieldClassName":"org.kie.workbench.common.forms.fields.shared.fieldTypes.relations.subForm.definition.SubFormFieldDefinition"},{"placeHolder":"processId","maxLength":100,"id":"field_0343037301175706E11","name":"processId","label":"processId","required":false,"readOnly":false,"validateOnChange":true,"binding":"processId","standaloneClassName":"java.lang.Long","code":"IntegerBox","serializedFieldClassName":"org.kie.workbench.common.forms.fields.shared.fieldTypes.basic.integerBox.definition.IntegerBoxFieldDefinition"},{"placeHolder":"id","maxLength":100,"id":"field_8974476327347064E11","name":"id","label":"id","required":false,"readOnly":false,"validateOnChange":true,"binding":"id","standaloneClassName":"java.lang.Long","code":"IntegerBox","serializedFieldClassName":"org.kie.workbench.common.forms.fields.shared.fieldTypes.basic.integerBox.definition.IntegerBoxFieldDefinition"},{"maxLength":100,"placeHolder":"status","id":"field_2615322777159243E12","name":"status","label":"status","required":false,"readOnly":false,"validateOnChange":true,"binding":"status","standaloneClassName":"java.lang.String","code":"TextBox","serializedFieldClassName":"org.kie.workbench.common.forms.fields.shared.fieldTypes.basic.textBox.definition.TextBoxFieldDefinition"}],"layoutTemplate":{"version":3,"style":"FLUID","layoutProperties":{},"rows":[{"properties":{},"layoutColumns":[{"span":"12","height":"12","properties":{},"rows":[],"layoutComponents":[{"dragTypeName":"org.kie.workbench.common.forms.editor.client.editor.rendering.EditorFieldLayoutComponent","properties":{"field_id":"field_410823013926966E12","form_id":"c2c5a59c-139c-4e0e-a6d3-00694519362c"},"parts":[]}]}]},{"properties":{},"layoutColumns":[{"span":"12","height":"12","properties":{},"rows":[],"layoutComponents":[{"dragTypeName":"org.kie.workbench.common.forms.editor.client.editor.rendering.EditorFieldLayoutComponent","properties":{"field_id":"field_0343037301175706E11","form_id":"c2c5a59c-139c-4e0e-a6d3-00694519362c"},"parts":[]}]}]},{"properties":{},"layoutColumns":[{"span":"12","height":"12","properties":{},"rows":[],"layoutComponents":[{"dragTypeName":"org.kie.workbench.common.forms.editor.client.editor.rendering.EditorFieldLayoutComponent","properties":{"field_id":"field_8974476327347064E11","form_id":"c2c5a59c-139c-4e0e-a6d3-00694519362c"},"parts":[]}]}]},{"properties":{},"layoutColumns":[{"span":"12","height":"12","properties":{},"rows":[],"layoutComponents":[{"dragTypeName":"org.kie.workbench.common.forms.editor.client.editor.rendering.EditorFieldLayoutComponent","properties":{"field_id":"field_2615322777159243E12","form_id":"c2c5a59c-139c-4e0e-a6d3-00694519362c"},"parts":[]}]}]}]}}