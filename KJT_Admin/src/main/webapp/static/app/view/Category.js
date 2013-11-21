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
                    width:200,
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
                },
                {
                    text: 'Delete',
                    action: 'delete'
                }
            ]
        }
    ],
    store: 'Category',
//    selType: 'cellmodel',
    selType: 'checkboxmodel',
    plugins: [
        Ext.create('Ext.grid.plugin.CellEditing', {
            clicksToEdit: 2
        })
    ],
    columns: [
//        { text: 'rowid', dataIndex: 'rowid' },
//        { text: 'cid', dataIndex: 'cid', editor: 'textfield' },
//        { text: 'rid', dataIndex: 'rid', editor: 'textfield' },
        { text: 'enName', dataIndex: 'enName', editor: 'textfield',width:200  },
        { text: 'cnName', dataIndex: 'cnName', editor: 'textfield' ,width:200 },
        { text: 'exName', dataIndex: 'exName', editor: 'textfield',width:200  },
        {
            text: 'categoryType',
            dataIndex: 'categoryType',
            editor: {
                xtype: 'combobox',
                editable: false,
                store: ['normal', 'riceRegular', 'riceComboApp', 'sideRegular', 'matrixMenu', 'comboApp'],
                name: 'categoryType',
                queryMode: 'local'
            }
        },
        { text: 'priority', dataIndex: 'priority', editor: 'textfield' },
        { text: 'priority2', dataIndex: 'priority2', editor: 'textfield' },
//        { text: 'extension', dataIndex: 'extension' },
        { text: 'defaultPrinterMask', dataIndex: 'defaultPrinterMask',width:150 ,
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
