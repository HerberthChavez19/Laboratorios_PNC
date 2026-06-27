package com.example.ejercicioevaluado03_pnc.services.implementations;

import com.example.ejercicioevaluado03_pnc.common.SpecimenMapper;
import com.example.ejercicioevaluado03_pnc.dto.request.CreateSpecimenRequest;
import com.example.ejercicioevaluado03_pnc.dto.request.UpdateSpecimenRequest;
import com.example.ejercicioevaluado03_pnc.dto.response.PageableResponse;
import com.example.ejercicioevaluado03_pnc.dto.response.SpecimenResponse;
import com.example.ejercicioevaluado03_pnc.exceptions.customs.ResourceNotFoundException;
import com.example.ejercicioevaluado03_pnc.model.Specimen;
import com.example.ejercicioevaluado03_pnc.repositories.SpecimenRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpecimenServiceImplTest {

    @Mock
    private SpecimenRepository specimenRepository;

    @Mock
    private SpecimenMapper specimenMapper;

    @InjectMocks
    private SpecimenServiceImpl specimenService;

    private UUID specimenId;
    private Specimen specimen;
    private SpecimenResponse specimenResponse;
    private CreateSpecimenRequest createRequest;
    private UpdateSpecimenRequest updateRequest;

    @BeforeEach
    void setUp() {
        specimenId = UUID.randomUUID();

        specimen = Specimen.builder()
                .id(specimenId)
                .name("Bokoblin")
                .region("Akkala Highlands")
                .dangerLevel(3)
                .isFriendly(false)
                .build();

        specimenResponse = SpecimenResponse.builder()
                .id(specimenId)
                .name("Bokoblin")
                .region("Akkala Highlands")
                .dangerLevel(3)
                .isFriendly(false)
                .build();

        createRequest = CreateSpecimenRequest.builder()
                .name("Bokoblin")
                .region("Akkala Highlands")
                .dangerLevel(3)
                .isFriendly(false)
                .build();

        updateRequest = UpdateSpecimenRequest.builder()
                .name("Blue Bokoblin")
                .region("Akkala Highlands")
                .dangerLevel(5)
                .isFriendly(false)
                .build();
    }

    // ──────────────────────────────────────────────────────────────
    // createSpecimen
    // ──────────────────────────────────────────────────────────────

    @Test
    void createSpecimen_ShouldReturnSpecimenResponse_WhenRequestIsValid() {
        when(specimenMapper.toEntityCreate(createRequest)).thenReturn(specimen);
        when(specimenRepository.save(specimen)).thenReturn(specimen);
        when(specimenMapper.toDto(specimen)).thenReturn(specimenResponse);

        SpecimenResponse result = specimenService.createSpecimen(createRequest);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("Bokoblin");
        assertThat(result.getDangerLevel()).isEqualTo(3);
        verify(specimenRepository, times(1)).save(specimen);
    }

    // ──────────────────────────────────────────────────────────────
    // getAllSpecimens
    // ──────────────────────────────────────────────────────────────

    @Test
    void getAllSpecimens_ShouldReturnPageableResponse_WhenSpecimensExist() {
        Page<Specimen> page = new PageImpl<>(List.of(specimen), PageRequest.of(0, 10), 1);
        PageableResponse<SpecimenResponse> expectedResponse = PageableResponse.<SpecimenResponse>builder()
                .content(List.of(specimenResponse))
                .page(0).size(10).totalElements(1L).totalPages(1)
                .first(true).last(true).empty(false).hasNext(false).hasPrevious(false)
                .build();

        when(specimenRepository.findAll(any(Pageable.class))).thenReturn(page);
        when(specimenMapper.toPageableResponse(page)).thenReturn(expectedResponse);

        PageableResponse<SpecimenResponse> result = specimenService.getAllSpecimens(0, 10, "name", "asc");

        assertThat(result).isNotNull();
        assertThat(result.getContent()).hasSize(1);
        assertThat(result.getTotalElements()).isEqualTo(1L);
        verify(specimenRepository, times(1)).findAll(any(Pageable.class));
    }

    @Test
    void getAllSpecimens_ShouldThrowResourceNotFoundException_WhenPageIsEmpty() {
        when(specimenRepository.findAll(any(Pageable.class))).thenReturn(Page.empty());

        assertThatThrownBy(() -> specimenService.getAllSpecimens(0, 10, "name", "asc"))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("No specimens are registered in Hyrule");
    }

    // ──────────────────────────────────────────────────────────────
    // getSpecimenById
    // ──────────────────────────────────────────────────────────────

    @Test
    void getSpecimenById_ShouldReturnSpecimenResponse_WhenIdExists() {
        when(specimenRepository.findById(specimenId)).thenReturn(Optional.of(specimen));
        when(specimenMapper.toDto(specimen)).thenReturn(specimenResponse);

        SpecimenResponse result = specimenService.getSpecimenById(specimenId);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(specimenId);
        assertThat(result.getRegion()).isEqualTo("Akkala Highlands");
        verify(specimenRepository, times(1)).findById(specimenId);
    }

    @Test
    void getSpecimenById_ShouldThrowResourceNotFoundException_WhenIdDoesNotExist() {
        when(specimenRepository.findById(specimenId)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> specimenService.getSpecimenById(specimenId))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("Specimen not found in Sheikah Slate records");
    }

    // ──────────────────────────────────────────────────────────────
    // updateSpecimen
    // ──────────────────────────────────────────────────────────────

    @Test
    void updateSpecimen_ShouldReturnUpdatedSpecimenResponse_WhenIdExists() {
        Specimen updatedSpecimen = Specimen.builder()
                .id(specimenId)
                .name("Blue Bokoblin")
                .region("Akkala Highlands")
                .dangerLevel(5)
                .isFriendly(false)
                .build();

        SpecimenResponse updatedResponse = SpecimenResponse.builder()
                .id(specimenId)
                .name("Blue Bokoblin")
                .region("Akkala Highlands")
                .dangerLevel(5)
                .isFriendly(false)
                .build();

        // updateSpecimen llama internamente a getSpecimenById(id) primero
        when(specimenRepository.findById(specimenId)).thenReturn(Optional.of(specimen));
        when(specimenMapper.toDto(specimen)).thenReturn(specimenResponse);

        // luego mapea y persiste la actualización
        when(specimenMapper.toEntityUpdate(updateRequest, specimenId)).thenReturn(updatedSpecimen);
        when(specimenRepository.save(updatedSpecimen)).thenReturn(updatedSpecimen);
        when(specimenMapper.toDto(updatedSpecimen)).thenReturn(updatedResponse);

        SpecimenResponse result = specimenService.updateSpecimen(specimenId, updateRequest);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("Blue Bokoblin");
        assertThat(result.getDangerLevel()).isEqualTo(5);
        verify(specimenRepository, times(1)).save(updatedSpecimen);
    }

    // ──────────────────────────────────────────────────────────────
    // deleteSpecimen
    // ──────────────────────────────────────────────────────────────

    @Test
    void deleteSpecimen_ShouldReturnDeletedSpecimenResponse_WhenIdExists() {
        when(specimenRepository.findById(specimenId)).thenReturn(Optional.of(specimen));
        when(specimenMapper.toDto(specimen)).thenReturn(specimenResponse);

        SpecimenResponse result = specimenService.deleteSpecimen(specimenId);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(specimenId);
        verify(specimenRepository, times(1)).deleteById(specimenId);
    }
}
