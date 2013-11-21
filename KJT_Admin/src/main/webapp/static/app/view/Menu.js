/**
 * Created with JetBrains PhpStorm.
 * @author ishowshao
 * @date 13-11-15
 */
Ext.define('Admin.view.Menu', {
    extend: 'Ext.tree.Panel',
    alias: 'widget.Admin-menu',

    title: 'System Menu',
    region: 'west',
    width: 200,
    collapsible: true,   // make collapsible
    split: true,
    layout: 'fit',
    id: 'west-region-container',
    rootVisible: false,

    initComponent: function() {
        this.store = Ext.create('Ext.data.TreeStore', {
            root: {
                expanded: true,
                children: [
                    { text: "Restaurant", leaf: true, id: 'restaurant' },
                    { text: "Category", leaf: true, id: 'category' },
                    { text: "Dish", leaf: true, id: 'dish' }
                ]
            }
        });

        this.callParent(arguments);
    }
});
