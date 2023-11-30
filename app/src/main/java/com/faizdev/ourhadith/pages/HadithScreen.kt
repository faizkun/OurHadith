package com.faizdev.ourhadith.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import com.faizdev.ourhadith.HadithComposeApplication
import com.faizdev.ourhadith.factory.ViewModelFactory
import com.faizdev.ourhadith.items.HadithItem
import com.faizdev.ourhadith.items.PerawiItem
import com.faizdev.ourhadith.ui.theme.satoshi
import com.faizdev.state.HadithState
import com.faizdev.viewmodel.HadithViewModel
import com.ramcosta.composedestinations.annotation.Destination


data class HadithListScreenNavArgs(
    val perawi: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Destination(
    navArgsDelegate = HadithListScreenNavArgs::class
)
@Composable
fun HadithScreen(
    viewModel: HadithViewModel = viewModel(
        factory = ViewModelFactory { handle ->
            HadithViewModel(HadithComposeApplication.repository, handle)
        }
    )


) {

    val hadithList = viewModel.hadithList.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = "${viewModel.perawiName}",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontFamily = satoshi,
                )
            })

        }
    ) {

        Column(modifier = Modifier.padding(it)) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(
                    hadithList.itemCount,
                    key = { hadithList[it]?.number!! },
                    contentType = hadithList.itemContentType { "hadithListPaging" }
                ) { index ->
                    val hadithItem = hadithList[index]
                    var isExpanded by remember {
                        mutableStateOf(false)
                    }

                    HadithItem(
                         noHadith = hadithItem!!.number,
                            hadith = hadithItem.arab,
                        translate = hadithItem.id,
                        perawiName = viewModel.perawiName


                    )
                }
                when(hadithList.loadState.refresh){
                    is LoadState.Error -> item{
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                            ){

                        }
                    }
                    is LoadState.Loading -> item{
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ){

                        }
                    }

                    else -> {}
                }




            }
        }
    }

}


//
//@Preview
//@Composable
//fun HomePreview() {
//    HomeActivty(
//
//    )
//
//}