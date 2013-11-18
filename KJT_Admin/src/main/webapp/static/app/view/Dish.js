/**
 * Created with JetBrains PhpStorm.
 * @author ishowshao
 * @date 13-11-16
 */
Ext.define('Admin.view.Dish' ,{
    extend: 'Ext.grid.Panel',
    alias: 'widget.dish',
    hidden: true,
    layout: 'fit',
    itemId: 'dish',
    title: 'Dish',
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
                    xtype: 'combobox',
                    editable: false,
                    store: 'DishCategory',
                    name: 'category',
                    queryMode: 'local',
                    valueField: 'cid',
                    displayField: 'enName',
                    action: 'category'
                },
                {
                    text: 'New Dish',
                    action: 'new'
                },
                {
                    text: 'Save',
                    action: 'save'
                },
                {
                    text: 'Reset',
                    action: 'reset'
                },
                {
                    xtype: 'textfield',
                    emptyText: 'Search',
                    action: 'search'
                }
            ]
        }
    ],
    store: 'Dish',
    selType: 'cellmodel',
    plugins: [
        Ext.create('Ext.grid.plugin.CellEditing', {
            clicksToEdit: 2
        })
    ],
    columns: [
//        { text: 'did', dataIndex: 'did' },
//        { text: 'rid', dataIndex: 'rid' },
//        { text: 'cid', dataIndex: 'cid' },
        { text: 'enName', dataIndex: 'enName', editor: 'textfield' },
        { text: 'cnName', dataIndex: 'cnName', editor: 'textfield' },
        { text: 'exName', dataIndex: 'exName', editor: 'textfield' },
        { text: 'description', dataIndex: 'description', editor: 'textfield' },
        {
            text: 'status',
            dataIndex: 'status',
            editor: {
                xtype: 'combobox',
                editable: false,
                store: ['normal', 'normal1', 'normal2'],
                name: 'status',
                queryMode: 'local'
            }
        },
        { text: 'manualPriority', dataIndex: 'manualPriority', editor: 'textfield' },
        { text: 'manualPriority2', dataIndex: 'manualPriority2', editor: 'textfield' },
        { text: 'autoPriority', dataIndex: 'autoPriority', editor: 'textfield' },
        { text: 'autoPriority2', dataIndex: 'autoPriority2', editor: 'textfield' },
        { text: 'subgroup', dataIndex: 'subgroup', editor: 'textfield' },
        { text: 'size1', dataIndex: 'size1', editor: 'textfield' },
        { text: 'size2', dataIndex: 'size2', editor: 'textfield' },
        { text: 'size3', dataIndex: 'size3', editor: 'textfield' },
        { text: 'size4', dataIndex: 'size4', editor: 'textfield' },
        { text: 'lunchSpecial', dataIndex: 'lunchSpecial', editor: 'textfield' },
        { text: 'dinnerSpecial', dataIndex: 'dinnerSpecial', editor: 'textfield' },
        { text: 'printerMask', dataIndex: 'printerMask', editor: 'textfield' }
    ]
});
