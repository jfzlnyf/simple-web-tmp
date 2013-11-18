/**
 * Created with JetBrains PhpStorm.
 * @author ishowshao
 * @date 13-11-16
 */
Ext.define('Admin.view.Category' ,{
    extend: 'Ext.grid.Panel',
    alias: 'widget.category',
    hidden: true,
    layout: 'fit',
    itemId: 'category',
    title: 'Category',
    dockedItems: [
        {
            xtype: 'toolbar',
            dock: 'top',
            items: [
                {
                    xtype: 'combobox',
                    editable: false,
                    store: 'Restaurant',
                    name: 'restaurant',
                    queryMode: 'local',
                    valueField: 'rid',
                    displayField: 'enName',
                    action: 'restaurant'
                },
                {
                    text: 'New Category',
                    action: 'new'
                },
                {
                    text: 'Save',
                    action: 'save'
                },
                {
                    text: 'Reset',
                    action: 'reset'
                }
            ]
        }
    ],
    store: 'Category',
    selType: 'cellmodel',
    plugins: [
        Ext.create('Ext.grid.plugin.CellEditing', {
            clicksToEdit: 2
        })
    ],
    columns: [
//        { text: 'rowid', dataIndex: 'rowid' },
//        { text: 'cid', dataIndex: 'cid', editor: 'textfield' },
//        { text: 'rid', dataIndex: 'rid', editor: 'textfield' },
        { text: 'enName', dataIndex: 'enName', editor: 'textfield' },
        { text: 'cnName', dataIndex: 'cnName', editor: 'textfield' },
        { text: 'exName', dataIndex: 'exName', editor: 'textfield' },
        {
            text: 'categoryType',
            dataIndex: 'categoryType',
            editor: {
                xtype: 'combobox',
                editable: false,
                store: ['normal', 'normal1', 'normal2'],
                name: 'categoryType',
                queryMode: 'local'
            }
        },
        { text: 'priority', dataIndex: 'priority', editor: 'textfield' },
        { text: 'priority2', dataIndex: 'priority2', editor: 'textfield' },
//        { text: 'extension', dataIndex: 'extension' },
        { text: 'defaultPrinterMask', dataIndex: 'defaultPrinterMask', editor: 'textfield' }
    ]
});
