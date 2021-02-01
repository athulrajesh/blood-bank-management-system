$(document).ready(function () {
    
    var table = $("#example").DataTable({
      bProcessing: true,
      bDeferRender: true,
      bAutoWidth: false,
      bServerSide: true,
      sAjaxSource: "/bms/receiver/viewlist",
      rowId: "username",
      
      iDisplayLength: 10,
      aLengthMenu: [
        [10, 25, 50, 100],
        [10, 25, 50, 100],
      ],
      sPaginationType: "full_numbers",
      bPaginate: true,
      fnServerParams: function (aoData) {
        console.log(aoData);
        // var clientId=$('#client_id_search').val();
        // var remitterId = $('#remitter_id_search').val();
        // var schemeId = $('#scheme_id_search').val();
        // var subSchemeId = $('#idSubSchemeIdSearch').val();
        // var status = $('#id-rem-status').val();
        var dataString = $("#searchbox").val();
        // if(dataStringPre!=null){
        // 	dataString=dataStringPre;
        // 	localStorage.clear();
        // }else{
        // 	 dataString = JSON.stringify({clientId : clientId,remitterId: remitterId, schemeId: schemeId,status:status,subSchemeId:subSchemeId});
        // }
  
        console.log(dataString);
  
        aoData.push({ name: "searchData", value: dataString });
      },
      fnServerData: function (sSource, aoData, fnCallback, oSettings) {
        oSettings.jqXHR = $.ajax({
          dataType: "json",
          url: sSource,
          data: aoData,
          success: fnCallback,
          error: function (e) {
            console.log(e.message);
          },
        });
      },
      bSort: false,
      sDom: "rt<lp>",
      aoColumns: [
        // {"mDataProp": "checkbox","mRender": function(checkbox){
        //     return '<input id="id-'+checkbox+'" name="remTabChkBox12" type="checkbox" value="'+checkbox+'"/>'
        // },"bSortable": false},
        { mDataProp: "username", bSortable: false },
        { mDataProp: "name", bSortable: false },
        { mDataProp: "bg", bSortable: false },
        { mDataProp: "age", bSortable: false },
  
        
        { mDataProp: "location", bSortable: false },
        { mDataProp: "phone", bSortable: false },
        { mDataProp: "email", bSortable: false },
        { mDataProp: "weight", bSortable: false },
        { mDataProp: "sex", bSortable: false },
        
      ],
    });
   
   
    $("#searchbox").on("input", function () {
      table.ajax.reload();
    });
  
    
  
   
  });
  
  