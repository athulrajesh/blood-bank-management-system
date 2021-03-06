$(document).ready(function () {
    var selected = [];
    var table = $("#example").DataTable({
      bProcessing: true,
      bDeferRender: true,
      bAutoWidth: false,
      bServerSide: true,
      sAjaxSource: "/bms/orderslist",
      rowId: "order_id",
      createdRow: function (row, data) {
        if ($.inArray(data.DT_RowId, selected) !== -1) {
          $(row).addClass("selected");
        }
      },
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
        { mDataProp: "order_id", bSortable: false },
        { mDataProp: "bg", bSortable: false },
        { mDataProp: "amount", bSortable: false },
        { mDataProp: "time", bSortable: false },
  
        
        
      ],
    });
    $("#del").click(function () {
      $.ajax({
        url: "./deleteorder",
        type: "POST",
        data: {
          id: selected,
        },
        success: function (data) {
          table.ajax.reload();
          selected = [];
          toastr.success("row deleted & status modified");
        },
        error: function (e) {
          console.log(e.message);
        },
      });
    });
    $("#example tbody").on("click", "tr", function () {
      var id = this.id;
      var index = $.inArray(id, selected);
  
      if (index === -1) {
        selected.push(id);
        $(this).addClass("selected");
      } else {
        selected.splice(index, 1);
        $(this).removeClass("selected");
      }
  
      console.log(selected);
      
      // $(this).toggleClass("selected");
    });
    $("#searchbox").on("input", function () {
      table.ajax.reload();
    });
  
    
  
   
  });
  
  