/**
 * Created with JetBrains PhpStorm.
 * @author ishowshao
 * @date 13-11-16
 */
Ext.define('Admin.model.Dish', {
    extend: 'Ext.data.Model',
    fields: [
        { name: 'rowid', type: 'number' },
        { name: 'did', type: 'string' },
        { name: 'rid', type: 'string' },
        { name: 'cid', type: 'string' },
        { name: 'enName', type: 'string' },
        { name: 'cnName', type: 'string' },
        { name: 'exName', type: 'string' },
        { name: 'status', type: 'string' },
        { name: 'manualPriority', type: 'number' },
        { name: 'manualPriority2', type: 'number' },
        { name: 'autoPriority', type: 'number' },
        { name: 'autoPriority2', type: 'number' },
        { name: 'subgroup', type: 'number' },
        { name: 'size1', type: 'number' },
        { name: 'size2', type: 'number' },
        { name: 'size3', type: 'number' },
        { name: 'size4', type: 'number' },
        { name: 'lunchSpecial', type: 'number' },
        { name: 'dinnerSpecial', type: 'number' },
        { name: 'printerMask', type: 'number' },
        { name: 'description', type: 'string' },
        { name: 'createTime', type: 'number' },
        { name: 'updateTime', type: 'number' }
    ]
});
