package com.example.profildeveloppeur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                DeveloperProfileScreen()
            }
        }
    }
}

@Composable
fun DeveloperProfileScreen(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {

            ProfileCard(
                name = "Yanis Buhot",
                role = "Développeur Web Full-Stack / Étudiant B.U.T. MMI",
                description = "Étudiant en M1 à l'ESGI, passioné par le design interface et le developpement full stack. Je suis disponible ici.",
                skills = listOf("Next.js", "React", "Node.js", "PostgreSQL", "Java"),
                onContactClick = {

                    println("Redirection vers la page de contact")
                },
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun ProfileCard(
    name: String,
    role: String,
    description: String,
    skills: List<String>,
    onContactClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shadowElevation = 4.dp,
        color = MaterialTheme.colorScheme.surfaceVariant,
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            ProfileHeader(name = name, role = role, description = description)

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Compétences :",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            skills.forEach { skill ->
                SkillItem(
                    skillName = skill,
                    modifier = Modifier.padding(bottom = 6.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            ContactAction(
                text = "Me contacter",
                onClick = onContactClick,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun ProfileHeader(
    name: String,
    role: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = name,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = role,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(top = 4.dp, bottom = 8.dp)
        )
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun SkillItem(
    skillName: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.primaryContainer,
        shape = MaterialTheme.shapes.small
    ) {
        Text(
            text = "• $skillName",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun ContactAction(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .clickable(
                onClick = onClick,
                role = Role.Button
            )
            .semantics {
                contentDescription = "Bouton permettant de $text"
            },
        color = MaterialTheme.colorScheme.primary,
        shape = MaterialTheme.shapes.medium
    ) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(16.dp), // Padding interne du bouton
            style = MaterialTheme.typography.labelLarge,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )
    }
}


// Preview 1 : Profil complet (Full-Stack)
@Preview(showBackground = true, name = "Profil Full-Stack")
@Composable
fun PreviewFullStackProfile() {
    MaterialTheme {
        ProfileCard(
            name = "Yanis Buhot",
            role = "Développeur Web Full-Stack",
            description = "Étudiant en M1 à l'ESGI, passioné par le design interface et le developpement full stack. Je suis disponible ici.",
            skills = listOf("Next.js", "React", "Node.js"),
            onContactClick = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}

// Preview 2 : Variante de profil (Junior Android)
@Preview(showBackground = true, name = "Profil Android Junior")
@Composable
fun PreviewJuniorAndroidProfile() {
    MaterialTheme {
        ProfileCard(
            name = "Alice Dupont",
            role = "Développeuse Android Junior",
            description = "À la recherche d'une alternance. Passionnée par la création d'UI réactives.",
            skills = listOf("Kotlin", "Jetpack Compose", "Git"),
            onContactClick = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}