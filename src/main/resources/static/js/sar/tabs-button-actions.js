	function nextAndPrevtab(direction)
	{
		var selectedTab = $(document).find('div[class^="ui-tabs"]').first();
		var selected = selectedTab.tabs("option","active");
		if(direction == "right")
		{
			selectedTab.tabs("option","active",selected+1);
		}
		else if(direction == "left")
		{
			selectedTab.tabs("option","active",selected-1);
		}
		
		if(selected == 0)
		{
			$("#btnMoveLeftTab").show();
		}
		selectedTab.tabs({
			activate:function(event,ui)
			{
				var active =   selectedTab.tabs("option","active");
				var selected = selectedTab.tabs("option","active");
				if(active == 0)
				{
					$("#btnMoveLeftTab").hide();
				} else if(selectedTab.find("li:not(li[style='display:none'])").size()-1==selected)
				{
					$("#btnMoveRightTab").hide();
				} else 
				{
					$("#btnMoveLeftTab").show();
					$("#btnMoveRightTab").show();
				}
			}
		});
		
	}

	/*$(".Footer").on('click',':button',function(){
			var selected = selectedTab.tabs("option","active");
			alert(selected+" === "+this.id);
			if(this.id=="btnMoveLeftTab")
			{
				if(selected>=1){
					selectedTab.tabs("option","active",selected-1);
				}
			}
			else{
				selectedTab.tabs("option","active",selected+1);
				}
			});
			selectedTab.tabs(
			{
				activate:function(event,ui){
					var active=selectedTab.tabs("option","active");
					var selected=selectedTab.tabs("option","active");
					if(active==0){
						$("#btnMoveLeftTab").hide();
					}else if(selectedTab.find("li:not(li[style='display:none'])").size()-1==selected)
					{
						$("#btnMoveRightTab").hide();
					}else{
						$("#btnMoveLeftTab").show();
						$("#btnMoveRightTab").show();
					}
				}
			});
			$("#btnMoveLeftTab").hide();
		});*/