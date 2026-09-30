package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Cores baseadas na imagem
val DarkBackground = Color(0xFF0F172A)
val CardBackground = Color(0xFF1E293B)
val AccentYellow = Color(0xFFFACC15)
val TextGray = Color(0xFF94A3B8)
val TagBackground = Color(0xFF334155)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colorScheme = darkColorScheme(background = DarkBackground)) {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Scaffold(
        containerColor = DarkBackground,
        bottomBar = { BottomNavigationBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            TopHeader()
            Spacer(modifier = Modifier.height(24.dp))

            // O Card principal ocupa o espaço restante
            Box(modifier = Modifier.weight(1f)) {
                GameCard()
            }

            Spacer(modifier = Modifier.height(16.dp))
            ActionButtons()
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun TopHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            // Avatar Placeholder
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(Color.Blue)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(text = "Olá, (nome de usuario)", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.LocationOn, contentDescription = null, tint = AccentYellow, modifier = Modifier.size(14.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "São Paulo, SP - 2km", color = TextGray, fontSize = 12.sp)
                }
            }
        }
        // Ícone de Filtro
        IconButton(
            onClick = { },
            modifier = Modifier
                .border(1.dp, TextGray.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
        ) {
            Icon(Icons.Default.Tune, contentDescription = "Filtro", tint = Color.White)
        }
    }
}

@Composable
fun GameCard() {
    Card(
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier.fillMaxSize(),
        colors = CardDefaults.cardColors(containerColor = CardBackground)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            // Imagem de Fundo (Substitua por sua imagem real)

                // Use uma imagem real aqui



            // Gradiente escuro para dar contraste aos textos
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Black.copy(alpha = 0.7f),
                                Color.Transparent,
                                Color.Black.copy(alpha = 0.9f)
                            )
                        )
                    )
            )

            // Conteúdo sobreposto
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // Topo do Card (Botões Pular/Jogar)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    OutlinedButton(
                        onClick = { },
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                        border = BorderStroke(1.dp, Color.White.copy(alpha = 0.5f)),
                        shape = RoundedCornerShape(50)
                    ) {
                        Icon(Icons.Default.Close, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("PULAR", fontSize = 12.sp)
                    }

                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = AccentYellow.copy(alpha = 0.8f), contentColor = Color.Black),
                        shape = RoundedCornerShape(50)
                    ) {
                        Icon(Icons.Default.Check, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("JOGAR", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }
                }

                // Base do Card (Informações)
                Column {
                    // Host e Avaliação
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(modifier = Modifier.size(24.dp).clip(CircleShape).background(Color.Gray))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Mesa do Rafael", color = Color.White, fontSize = 14.sp)
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Star, contentDescription = null, tint = AccentYellow, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("4.8", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Título
                    Text("Dungeons & Dragons\n5e", color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold, lineHeight = 32.sp)

                    Spacer(modifier = Modifier.height(12.dp))

                    // Tags
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        TagChip("RPG", isHighlighted = true)
                        TagChip("Presencial")
                        TagChip("Iniciantes Bem-vindos")
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Detalhes (Jogadores, Distância, Data)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        DetailItem(Icons.Default.Group, "3/5 jogadores")
                        DetailItem(Icons.Default.LocationOn, "1.2 km")
                        DetailItem(Icons.Default.AccessTime, "Sáb, 30 Ago - 19h")
                    }
                }
            }
        }
    }
}

@Composable
fun TagChip(text: String, isHighlighted: Boolean = false) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(if (isHighlighted) AccentYellow else TagBackground)
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(
            text = text,
            color = if (isHighlighted) Color.Black else Color.White,
            fontSize = 12.sp,
            fontWeight = if (isHighlighted) FontWeight.Bold else FontWeight.Normal
        )
    }
}

@Composable
fun DetailItem(icon: ImageVector, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, contentDescription = null, tint = AccentYellow, modifier = Modifier.size(16.dp))
        Spacer(modifier = Modifier.width(4.dp))
        Text(text, color = Color.White, fontSize = 12.sp)
    }
}

@Composable
fun ActionButtons() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Botão Voltar
        IconButton(
            onClick = { },
            modifier = Modifier.size(48.dp).border(1.dp, TextGray.copy(alpha = 0.3f), CircleShape)
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Voltar", tint = TextGray)
        }

        // Botão Fechar
        IconButton(
            onClick = { },
            modifier = Modifier.size(48.dp).border(1.dp, TextGray.copy(alpha = 0.3f), CircleShape)
        ) {
            Icon(Icons.Default.Close, contentDescription = "Fechar", tint = TextGray)
        }

        // Botão Favoritar
        IconButton(
            onClick = { },
            modifier = Modifier.size(48.dp).border(1.dp, TextGray.copy(alpha = 0.3f), CircleShape)
        ) {
            Icon(Icons.Default.StarBorder, contentDescription = "Favoritar", tint = TextGray)
        }

        // Botão Confirmar (Amarelo)
        IconButton(
            onClick = { },
            modifier = Modifier.size(64.dp).background(AccentYellow, CircleShape)
        ) {
            Icon(Icons.Default.Check, contentDescription = "Confirmar", tint = Color.Black, modifier = Modifier.size(32.dp))
        }
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar(containerColor = DarkBackground, tonalElevation = 0.dp) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Explore, contentDescription = null) },
            label = { Text("Descobertas", fontSize = 10.sp) },
            selected = true,
            onClick = { },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = AccentYellow,
                selectedTextColor = AccentYellow,
                unselectedIconColor = TextGray,
                unselectedTextColor = TextGray,
                indicatorColor = Color.Transparent
            )
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.GridView, contentDescription = null) },
            label = { Text("Mesas", fontSize = 10.sp) },
            selected = false,
            onClick = { },
            colors = NavigationBarItemDefaults.colors(unselectedIconColor = TextGray, unselectedTextColor = TextGray)
        )
        NavigationBarItem(
            icon = {
                BadgedBox(badge = { Badge(containerColor = Color(0xFFEF4444)) { Text("1") } }) {
                    Icon(Icons.Default.Chat, contentDescription = null)
                }
            },
            label = { Text("Mensagens", fontSize = 10.sp) },
            selected = false,
            onClick = { },
            colors = NavigationBarItemDefaults.colors(unselectedIconColor = TextGray, unselectedTextColor = TextGray)
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Map, contentDescription = null) },
            label = { Text("Mapa", fontSize = 10.sp) },
            selected = false,
            onClick = { },
            colors = NavigationBarItemDefaults.colors(unselectedIconColor = TextGray, unselectedTextColor = TextGray)
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = null) },
            label = { Text("Perfil", fontSize = 10.sp) },
            selected = false,
            onClick = { },
            colors = NavigationBarItemDefaults.colors(unselectedIconColor = TextGray, unselectedTextColor = TextGray)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0F172A)
@Composable
fun MainScreenPreview() {
    MaterialTheme(colorScheme = darkColorScheme(background = DarkBackground)) {
        MainScreen()
    }
}