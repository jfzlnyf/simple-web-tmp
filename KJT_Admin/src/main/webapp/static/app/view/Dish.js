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
                    action: 'restaurant',
                    width:200
                },
                {
                    xtype: 'combobox',
                    editable: false,
                    store: 'DishCategory',
                    name: 'category',
                    queryMode: 'local',
                    valueField: 'cid',
                    displayField: 'enName',
                    action: 'category',
                    width:200
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
                    text: 'Delete',
                    action: 'delete'
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
    selType: 'checkboxmodel',
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
                store: ['normal', 'paused'],
                name: 'status',
                queryMode: 'local'
            }
        },
        { text: 'manualPriority', dataIndex: 'manualPriority', editor: 'numberfield' },
        { text: 'manualPriority2', dataIndex: 'manualPriority2', editor: 'numberfield' },
        { text: 'autoPriority', dataIndex: 'autoPriority', editor: 'numberfield' },
        { text: 'autoPriority2', dataIndex: 'autoPriority2', editor: 'numberfield' },
        { text: 'subgroup', dataIndex: 'subgroup', editor: 'numberfield' },
        { text: 'size1', dataIndex: 'size1', editor: 'numberfield' },
        { text: 'size2', dataIndex: 'size2', editor: 'numberfield' },
        { text: 'size3', dataIndex: 'size3', editor: 'numberfield' },
        { text: 'size4', dataIndex: 'size4', editor: 'numberfield' },
        { text: 'lunchSpecial', dataIndex: 'lunchSpecial', editor: 'numberfield' },
        { text: 'dinnerSpecial', dataIndex: 'dinnerSpecial', editor: 'numberfield' },
        {
            text: 'printerMask',
            dataIndex: 'printerMask',
            width:200,
            editor: {
                xtype: 'combobox',
                editable: false,
                valueField: 'value',
                nameField:'name',
                store:[
                    [1,"Front Desk Only"],
                    [2,"Fryer Printer Only"],
                    [3,"Front Desk and Fryer Printer"],
                    [4,"Kitchen Printer Only"],
                    [5,"Front Desk and Kitchen Printer"],
                    [6,"Fryer Printer and Kitchen Printer"],
                    [7,"All Printers"]

                ],
                name: 'status',
                queryMode: 'local'
            }
        }
    ]
});
